import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kazuki
 *	エラーコード、エラー内容の定数定義クラス
 */
public class ErrorConstants {

	public static final Map<Integer, String> ExceptionContentsMaster;

	static {
		Map<Integer, String> exception = new HashMap<Integer, String>();

		exception.put(32, "ユーザーを認証できませんでした。");
		exception.put(34, "ページが見つかりませんでした。	");
		exception.put(64, "あなたのアカウントは凍結されています。");
		exception.put(68, "API v1はもう使えないのでAPI v1.1に統合してください。");
		exception.put(88, "レート制限を超えました。");
		exception.put(89, "	Access Tokenが無効、もしくは期限切れです。");
		exception.put(92, "	SSLが必要です");
		exception.put(130, "容量オーバー（訳注：原文はOver Capacity）");
		exception.put(131, "内部エラー");
		exception.put(135, "ユーザーを認証できませんでした。");
		exception.put(161, "	今はこれ以上フォローできません。");
		exception.put(179, "	このステータスを見る権限がありません。");
		exception.put(185, "	一日のTweet回数制限をオーバーしました。");
		exception.put(187, "	ステータスが重複しています。");
		exception.put(215, "認証データに誤りがあります。");
		exception.put(226, "	このリクエストは自動送信の疑いがあります。悪意ある行動から他のユーザを守るため、このアクションは実行されませんでした。");
		exception.put(231, "	ログインを確認する必要があります。");
		exception.put(251, "このエンドポイントは現在使用されておりません。");
		exception.put(261, "アプリケーションに書き込み権限がありません。");

		ExceptionContentsMaster = Collections.unmodifiableMap(exception);
	}
}
