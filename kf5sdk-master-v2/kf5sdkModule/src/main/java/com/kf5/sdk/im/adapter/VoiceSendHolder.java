package com.kf5.sdk.im.adapter;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kf5.sdk.R;
import com.kf5.sdk.im.api.FileDownLoadCallBack;
import com.kf5.sdk.im.entity.IMMessage;
import com.kf5.sdk.im.widget.CircleImageView;

import java.util.List;

/**
 * author:chosen
 * date:2016/10/26 15:15
 * email:812219713@qq.com
 */

class VoiceSendHolder extends AbstractHolder {

    private TextView textViewLength;

    private CircleImageView headImg;

    private RelativeLayout relativeLayout;

    private ProgressBar progressBar;

    private TextView tvDate;


    VoiceSendHolder(View convertView) {
        super(convertView.getContext());
        headImg = (CircleImageView) convertView.findViewById(R.id.kf5_message_item_with_voice_head_img);
        textViewLength = (TextView) convertView.findViewById(R.id.kf5_message_item_with_voice);
        tvDate = (TextView) convertView.findViewById(R.id.kf5_tvDate);
        progressBar = (ProgressBar) convertView.findViewById(R.id.kf5_progressbar);
        relativeLayout = (RelativeLayout) convertView.findViewById(R.id.kf5_progress_layout);
        convertView.setTag(this);
    }

    public void bindData(IMMessage message, int position, IMMessage previousMessage, List<String> downLoadList, FileDownLoadCallBack callBack) {

        try {
            loadVoiceData(position, message, textViewLength, null, downLoadList, callBack);
            loadImage(headImg, R.drawable.kf5_end_user);
            dealMessageStatus(message, previousMessage, position, tvDate, progressBar, relativeLayout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

