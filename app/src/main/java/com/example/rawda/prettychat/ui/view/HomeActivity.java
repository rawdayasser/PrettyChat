package com.example.rawda.prettychat.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.rawda.prettychat.R;
import com.example.rawda.prettychat.data.models.Post;
import com.example.rawda.prettychat.data.models.User;
import com.example.rawda.prettychat.ui.adapter.HomePostAdapter;
import com.example.rawda.prettychat.utils.ImageUtil;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Post> posts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        HomePostAdapter homePostAdapter;
    }
    private void initialize_posts(){
        DateFormat dateFormat = new DateFormat() {
            @Override
            public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
                stringBuffer.append(date.toString());
                return stringBuffer;
            }

            @Override
            public Date parse(String s, ParsePosition parsePosition) {

                return null;
            }
        };
        dateFormat.format(new Date(2019, 4, 3));
        User user = new User("Rawda", "Yasser", "rawdayasser123@gmail.com",
                "rawda000", "1234", dateFormat.parse("", null),
                "1234", "Giza", );

        Post post = new Post();
    }
}
