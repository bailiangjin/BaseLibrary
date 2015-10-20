package com.kevin.building.utils;

import android.content.Intent;

import com.kevin.building.activity.DatabaseActivity;
import com.kevin.building.activity.NewMainActivity;
import com.kevin.building.app.AppManager;
import com.kevin.building.base.BaseActivity;

/**
 * 
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月25日 上午10:31:08 
 *
 */
public class ActivityUtils
{

	private static void startActivity(BaseActivity context, Intent intent)
	{
		AppManager.getInstance().startActivity(context, intent);
	}

	public static void startAMainActivity(BaseActivity context)
	{
		Intent intent = new Intent(context, NewMainActivity.class);
		startActivity(context, intent);
	}

	public static void startDatabaseActivity(BaseActivity context)
	{
		Intent intent = new Intent(context, DatabaseActivity.class);
		startActivity(context, intent);
	}

	// /**
	// * 根据 会话记录（ChatRecorder）打开 会话页面
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param chatRecorder
	// */
	// public static void startSessonActivity(Context context, String
	// mCurrentUser, ChatRecoder chatRecorder)
	// {
	// Intent intent = null;
	// if (chatRecorder.getType() == MessageTypeCst.RECODER_SIGLE)
	// {
	// intent = new Intent(context, ChatActivity.class);
	// intent.putExtra("nid", chatRecorder.getNid());
	// intent.putExtra("user", mCurrentUser);
	// }
	// else if (chatRecorder.getType() == MessageTypeCst.RECODER_MUTIL)
	// {
	// intent = new Intent(context, MultiRoomActivity.class);
	// intent.putExtra("gid", chatRecorder.getNid());
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("title", chatRecorder.getNickName());
	// }
	// else if (chatRecorder.getType() == MessageTypeCst.OPT_MUITL_ADDUSER)
	// {
	// intent = new Intent(context, MultiRoomActivity.class);
	// intent.putExtra("gid", chatRecorder.getNid());
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("title", chatRecorder.getNickName());
	// }
	// else if (chatRecorder.getType() == MessageTypeCst.RECODER_PUBLIC)
	// {
	// intent = new Intent(context, PublicAccountActivity.class);
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("nid", chatRecorder.getNid());
	// }
	// else if (chatRecorder.getType() == MessageTypeCst.RECODER_PUBLIC)
	// {
	// intent = new Intent(context, PublicAccountActivity.class);
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("nid", chatRecorder.getNid());
	// }
	// AppManager.getAppManager().startActivity((Activity) context, intent);
	// }

	// /**
	// * 打开WebViewActivity
	// *
	// * @param context
	// * @param mCurrentUser
	// */
	// public static void startPublicWebViewActivity(Activity context, String
	// mCurrentUser, String title, String url)
	// {
	// Intent intent = new Intent(context, PublicWebViewActivity.class);
	// intent.putExtra("nid", mCurrentUser);
	// intent.putExtra("title", title);
	// intent.putExtra("url", url);
	// AppManager.getAppManager().startActivity(context, intent);
	// }

	// /**
	// * 打开全局搜索Activity
	// *
	// * @param context
	// * @param mCurrentUser
	// */
	// public static void startGlobalSearchActivity(Activity context, String
	// mCurrentUser)
	// {
	// Intent intent = new Intent(context, GlobalSearchActivity.class);
	// intent.putExtra("nid", mCurrentUser);
	// AppManager.getAppManager().startActivity(context, intent);
	// }
	//
	// /**
	// * 打开公共账号Activity
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param userNID
	// */
	// public static void startPublicAccountActivity(Activity context, String
	// mCurrentUser, String publicAccountID)
	// {
	// Intent intent = new Intent(context, PublicAccountActivity.class);
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("nid", publicAccountID);
	// AppManager.getAppManager().startActivity(context, intent);
	//
	// }
	//
	// /**
	// * 打开个人详情Activity
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param userNID
	// */
	// public static void startUserinfoActivity(Activity context, String
	// mCurrentUser, String userNID)
	// {
	// Intent infoIntent = new Intent(context, IMUserInfoActivity.class);
	// infoIntent.putExtra("user", mCurrentUser);
	// infoIntent.putExtra("nid", userNID);
	// AppManager.getAppManager().startActivity(context, infoIntent);
	//
	// }
	//
	// /**
	// * 开启单人聊天activity
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param userNID
	// * @param userName
	// */
	// public static void startChatActivity(Activity context, String
	// mCurrentUser, String userNID, String userName)
	// {
	// Intent intent = new Intent(context, ChatActivity.class);
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("nid", userNID);
	// AppManager.getAppManager().startActivity(context, intent);
	//
	// }
	//
	// /**
	// * 开启群聊天Activity
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param GID
	// * @param groupName
	// */
	// public static void startMuiltyRoomActivity(Activity context, String
	// mCurrentUser, String GID, String groupName)
	// {
	// Intent intent = new Intent(context, MultiRoomActivity.class);
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("gid", GID);
	// intent.putExtra("title", groupName);
	// AppManager.getAppManager().startActivity(context, intent);
	//
	// }
	//
	// /**
	// * 打开聊天记录 自动识别群组和单人
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param chatRecoder
	// */
	// public static void startRecordActivity(Activity context, String
	// mCurrentUser, ChatRecoder chatRecoder)
	// {
	// if (chatRecoder == null)
	// {
	// LogUtils.e("用于打开聊天记录的 聊天记录对象 不能为空");
	// return;
	// }
	// Intent intent = null;
	// if (chatRecoder.getType() == MessageTypeCst.RECODER_SIGLE)
	// {
	// intent = new Intent(context, ChatActivity.class);
	// intent.putExtra("nid", chatRecoder.getNid());
	// intent.putExtra("user", mCurrentUser);
	// }
	// else if (chatRecoder.getType() == MessageTypeCst.RECODER_MUTIL)
	// {
	// intent = new Intent(context, MultiRoomActivity.class);
	// intent.putExtra("gid", chatRecoder.getNid());
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("title", chatRecoder.getNickName());
	// }
	// else if (chatRecoder.getType() == MessageTypeCst.OPT_MUITL_ADDUSER)
	// {
	// intent = new Intent(context, MultiRoomActivity.class);
	// intent.putExtra("gid", chatRecoder.getNid());
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("title", chatRecoder.getNickName());
	// }
	//
	// AppManager.getAppManager().startActivity(context, intent);
	//
	// }
	//
	// /**
	// * 打开选择联系人Activity
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param where
	// * @param chatMessage
	// */
	// public static void startSelectLinkManActivity(Activity context, String
	// mCurrentUser, String where,
	// ChatMessage chatMessage)
	// {
	// Intent intent = new Intent(context, IMSelectLinkManActivity.class);
	// intent.putExtra("where", where);
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("message", chatMessage);
	// AppManager.getAppManager().startActivity(context, intent);
	// }
	//
	// /**
	// * 打开文件详情Activity
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param fileManager
	// */
	// public static void startFileInfoActivity(Activity context, String
	// mCurrentUser, FileManager fileManager)
	// {
	// Intent intent = new Intent(context, FileInfoUploadActivity.class);
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("filemanage", fileManager);
	// AppManager.getAppManager().startActivity(context, intent);
	// }
	//
	// /**
	// * 打开文件分享Activity：Dialog
	// *
	// * @param context
	// * @param mCurrentUser
	// * @param chatMessage
	// */
	// public static void startFileShareActivity(Activity context, String
	// mCurrentUser, String fileName,
	// String downloadUrl, MessageEntity chatMessage)
	// {
	// Intent intent = new Intent(context, WXEntryActivity.class);
	// intent.putExtra("user", mCurrentUser);
	// intent.putExtra("downloadUrl", downloadUrl);
	// intent.putExtra("fileName", fileName);
	// intent.putExtra("chatMessage", chatMessage);
	// context.startActivity(intent);
	// context.overridePendingTransition(R.anim.activity_up_in,
	// R.anim.activity_up_in);
	// }

}
