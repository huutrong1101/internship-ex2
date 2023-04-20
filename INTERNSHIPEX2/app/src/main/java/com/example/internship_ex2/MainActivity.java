package com.example.internship_ex2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText mInputEditText;
    private EditText mOutputEditText;
    private EditText mNumCharsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tham chiếu đến các giá trị trong activity_main
        mInputEditText = findViewById(R.id.edit_text_input);
        mOutputEditText = findViewById(R.id.edit_text_output);
        mNumCharsEditText = findViewById(R.id.edit_text_n);
        Button reverseButton = findViewById(R.id.button_reverse);

        // set onClick cho reverseButton
        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reverseString();
            }
        });
    }

    private void reverseString() {
        // Lấy chuỗi đầu vào và số kí tự
        String input = mInputEditText.getText().toString().trim();
        String numCharsString = mNumCharsEditText.getText().toString().trim();

        // nếu 1 trong 2 giá trị trống thì trả về thông báo
        if (TextUtils.isEmpty(input) || TextUtils.isEmpty(numCharsString)) {
            Toast.makeText(this, "Please enter a string and a number of characters to reverse", Toast.LENGTH_SHORT).show();
            return;
        }

        // Chuyển kiểu dữ liệu từ string sang int
        int numChars = Integer.parseInt(numCharsString);

        // Nếu số lượng kí tự cần đảo ngược lớn hơn độ dài của chuỗi đầu vào thì hiển thị thông báo
        if (numChars > input.length()) {
            Toast.makeText(this, "Number of characters to reverse must be less than or equal to the length of the input string", Toast.LENGTH_SHORT).show();
            return;
        }

        // Đảo ngược N kí tự đầu tiên của chuỗi đầu vào
        String output = reverseNChars(input, numChars);

        // hiển thị chuỗi kết quả ra màn hình
        mOutputEditText.setText(output);
    }

    private String reverseNChars(String s, int n) {
        // Chuyển đổi chhuỗi đầu vào thành một mảng char
        char[] chars = s.toCharArray();

        // Đảo ngược N ký tự đầu tiên của mảng char
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i - 1];
            chars[n - i - 1] = temp;
        }

        // chuyển đổi mảng char trở lại một chuỗi
        return new String(chars);
    }
}