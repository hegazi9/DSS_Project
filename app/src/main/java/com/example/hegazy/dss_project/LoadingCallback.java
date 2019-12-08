package com.example.hegazy.dss_project;

import android.app.ProgressDialog;
import android.content.Context;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class LoadingCallback<T> implements AsyncCallback<T>
{
    private Context context;
    private ProgressDialog progressDialog;


    public LoadingCallback( Context context )
    {
        this( context, context.getString( R.string.loading_empty ) );
    }

    public LoadingCallback( Context context, String loadingMessage )
    {
        this.context = context;
        progressDialog = new ProgressDialog( context );
        progressDialog.setMessage( loadingMessage );
    }

    @Override
    public void handleResponse( T response )
    {
        progressDialog.dismiss();
    }

    @Override
    public void handleFault( BackendlessFault fault )
    {
        progressDialog.dismiss();
        DialogHelper.createErrorDialog( context, "BackendlessFault", fault.getMessage() ).show();
    }

    public void showLoading()
    {
        progressDialog.show();
    }

    public void hideLoading()
    {
        progressDialog.dismiss();
    }
}