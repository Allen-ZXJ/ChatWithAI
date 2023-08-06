package com.zxj.chatwithai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zxj.chatwithai.adapter.ChatAdapter;
import com.zxj.chatwithai.bean.ChatMessage;
import com.zxj.chatwithai.bean.ChatResult;
import com.zxj.chatwithai.constrains.TypeConstrain;
import com.zxj.chatwithai.repository.MessageStore;
import com.zxj.chatwithai.utils.NetworkUtils;

import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements RespCallBack {

    private RecyclerView mRvChat;
    private Gson mGson;
    private ChatAdapter adapter;
    private EditText mEdQuestion;
    private Button mBtSend;
    private String apiUrl = "https://api.openai.com/v1/engines/davinci/completions";
    private int maxTokens = 200;
    float temperature = 0.7f;
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGson = new Gson();
        MessageStore.addMessage(new ChatMessage("准备好了吗", TypeConstrain.TYPE_ME_CHAT));
        MessageStore.addMessage(new ChatMessage("准备好了", TypeConstrain.TYPE_AI_CHAT));
        mRvChat = (RecyclerView) findViewById(R.id.mRv_chat);
        mEdQuestion = findViewById(R.id.mEd_question);
        mBtSend = findViewById(R.id.mBt_send);
        adapter = new ChatAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvChat.setLayoutManager(layoutManager);
        mRvChat.setAdapter(adapter);
        mBtSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = mEdQuestion.getText().toString().trim();
                MessageStore.addMessage(new ChatMessage(question,TypeConstrain.TYPE_ME_CHAT));
                adapter.notifyItemInserted(MessageStore.chatData.size()-1);
                mRvChat.scrollToPosition(MessageStore.chatData.size()-1);
                if(!question.equals("")){
                    MediaType mediaType = MediaType.parse("application/json");
                    String requestBody = String.format("{\"prompt\": \"%s\", \"max_tokens\": %d, \"temperature\": %f}",question, maxTokens, temperature);
                    RequestBody jsonRequestBody = RequestBody.create(mediaType, requestBody);
                    Request request = new Request.Builder()
                            .url(apiUrl)
                            .post(jsonRequestBody)
                            .addHeader("Authorization", ChatApplication.getAuthorization())
                            .addHeader("OpenAI-Organization",ChatApplication.getOrganization())
                            .addHeader("Content-Type", "application/json")
                            .build();
                    Log.d(TAG,ChatApplication.getAuthorization());
                    Log.d(TAG,ChatApplication.getOrganization());
                    NetworkUtils.enqueue(request,MainActivity.this);
                    mEdQuestion.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"请输入问题?",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    @Override
    public void succeed(String response) {
        ChatResult result = mGson.fromJson(response, ChatResult.class);
        MessageStore.addMessage(new ChatMessage(result.getChoices().get(0).getText(),TypeConstrain.TYPE_AI_CHAT));
        runOnUiThread(()->{
            adapter.notifyItemInserted(MessageStore.chatData.size()-1);
            mRvChat.scrollToPosition(MessageStore.chatData.size()-1);
        });
        Log.d(TAG, "succeed: \n" + response);
    }

    @Override
    public void failed(String errorMessage) {
        Log.d(TAG, "failed: \n" + errorMessage);
        runOnUiThread(()->{
            Toast.makeText(this,"访问失败",Toast.LENGTH_LONG).show();
        });
    }


}