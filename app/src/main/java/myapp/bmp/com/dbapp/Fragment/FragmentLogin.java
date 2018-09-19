package myapp.bmp.com.dbapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myapp.bmp.com.dbapp.R;

public class FragmentLogin extends Fragment {
    myDB mydb;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register,container,false);
        mydb = new myDB(getActivity());
        mydb.getWritableDatabase();
        Log.d("18SepV1","Create db complete");
        final EditText id = v.findViewById(R.id.txtid);
        final EditText email = v.findViewById(R.id.txtemail);
        final EditText pwd = v.findViewById(R.id.txtpwd);
        Button btnsave = v.findViewById(R.id.btnsave);
        Button btncencel = v.findViewById(R.id.btncancel);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long r = mydb.InserData(id.getText().toString(),
                        email.getText().toString(),
                        pwd.getText().toString());
                if(r>0){
                    Toast.makeText(FragmentLogin.this.getContext(),"Save Data complete",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(FragmentLogin.this.getContext(),"Can not Save Data ",Toast.LENGTH_LONG).show();
                }
            }
        });


        return v;
    }
}
