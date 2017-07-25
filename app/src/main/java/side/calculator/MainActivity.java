package side.calculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_point;
    Button btn_clear;
    Button btn_del;
    Button btn_add;
    Button btn_minus;
    Button btn_multi;
    Button btn_divide;
    Button btn_equal;
    Button btn_mod;
    EditText et_input;
    boolean clear_flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        et_input = (EditText) findViewById(R.id.ed_input);
        btn_mod = (Button) findViewById(R.id.btn_modulus);


        MyButtonListener listener = new MyButtonListener();
        btn_0.setOnClickListener(listener);
        btn_1.setOnClickListener(listener);
        btn_2.setOnClickListener(listener);
        btn_3.setOnClickListener(listener);
        btn_4.setOnClickListener(listener);
        btn_5.setOnClickListener(listener);
        btn_6.setOnClickListener(listener);
        btn_7.setOnClickListener(listener);
        btn_8.setOnClickListener(listener);
        btn_9.setOnClickListener(listener);
        btn_point.setOnClickListener(listener);
        btn_clear.setOnClickListener(listener);
        btn_del.setOnClickListener(listener);
        btn_add.setOnClickListener(listener);
        btn_minus.setOnClickListener(listener);
        btn_multi.setOnClickListener(listener);
        btn_divide.setOnClickListener(listener);
        btn_equal.setOnClickListener(listener);
        btn_mod.setOnClickListener(listener);
    }




   class MyButtonListener implements View.OnClickListener{
       @Override
       public void onClick(View v) {
           String str= et_input.getText().toString();
           switch (v.getId()){
               case R.id.btn_0:
               case R.id.btn_1:
               case R.id.btn_2:
               case R.id.btn_3:
               case R.id.btn_4:
               case R.id.btn_5:
               case R.id.btn_6:
               case R.id.btn_7:
               case R.id.btn_8:
               case R.id.btn_9:

                   if(clear_flag){
                       clear_flag=false;
                       str="";
                       et_input.setText("");
                   }

                   if(!str.startsWith("0")||str.length()>1)
                       et_input.setText(str + ((Button)v).getText());

                   else if(str.startsWith("0") && v.getId()!=R.id.btn_0)
                       et_input.setText(((Button)v).getText());
                   break;
               case R.id.btn_point:

                   if(clear_flag){
                       clear_flag=false;
                       et_input.setText("");
                   }

                   if(str.contains(" ")){
                       String s2 = str.substring(str.indexOf(" ")+2);
                       if(!s2.contains("."))
                           et_input.setText(str + ((Button)v).getText());
                   }else if(!str.contains(".")){
                       et_input.setText(str + ((Button)v).getText());
                   }
                   break;
               case R.id.btn_add:
               case R.id.btn_minus:
               case R.id.btn_multi:
               case R.id.btn_divide:
               case R.id.btn_modulus:

                   if(clear_flag){
                       clear_flag=false;
                   }
                   if(!str.contains(" "))
                       et_input.setText(str +" "+ ((Button)v).getText() + " ");
                   break;
               case R.id.btn_clear:
                   clear_flag=false;
                   et_input.setText("");
                   break;
               case R.id.btn_del:

                   if(str!=null && !str.equals("")){

                       getNegation mgetNegation = new getNegation();
                       et_input.setText(Double.toString(mgetNegation.getNegation(str)));
                   }
                   break;
               case R.id.btn_equal:
                   getResult();
                   break;
           }
       }
   }


    private void getResult(){
        String exp = et_input.getText().toString();

        if (exp==null || exp.equals(""))
            return;

        if (!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        double result = 0;
        String s1 = exp.substring(0,exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2 = exp.substring(exp.indexOf(" ")+3);
        //s1 op s2
        if (!s1.equals("") && !s2.equals("")){
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);

            if(op.equals("+")){
                getAddition mgetAddition = new getAddition();
                result = mgetAddition.getAddition(d1, d2);
            }else if (op.equals("-")){

                getSubtraction mgetSubtraction = new getSubtraction();
                result= mgetSubtraction.getSubtraction(d1,d2);
            }else if (op.equals("×")) {

                getMultiplication mgetMultiplication = new getMultiplication();

                result = mgetMultiplication.getMultiplication(d1,d2);
            }else {
                getDivision mgetDivision = new getDivision();
                if (d2==0)
                    result=0;
                else if(op.equals("%")) {

                    getMod mgetMod = new getMod();
                    result = mgetMod.getMod(d1,d2);
                }
                else
                result=mgetDivision.getDivision(d1,d2);
            }
            String resultstr = result+"";

            String endstr = resultstr.substring(resultstr.indexOf(".")+1);
            if(endstr.equals("0")){
                int rs = (int)result;
                et_input.setText(rs+"");
            }
            else {
                et_input.setText(result + "");
            }
        }
        //op s2
        else if(s1.equals("") && !s2.equals("")){
            double d2 = Double.parseDouble(s2);

            if(op.equals("+")){
                result = d2;
            }else if (op.equals("-")){
                result=0-d2;
            }else if (op.equals("×")){
                result=0;
            }else {
                result=0;
            }
            int rs = (int)result;
            et_input.setText(rs+"");
        }
        //s1 op
        else if(!s1.equals("") && s2.equals("")){
            et_input.setText(exp);
        }
    }
}
