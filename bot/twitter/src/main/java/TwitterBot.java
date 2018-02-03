import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Twitteの投稿を行うクラス
 * @author kazuki
 */
public class TwitterBot {

	/**
	 * レガシーサイトのURLをTwitterに投稿する。
	 * @param url
	 * 		レガシーサイトのURL
	 *
	 * @throws TwitterException
	 * 		エラー内容は、クラス"ErrorConstants"に記載
	 */
	public void postToTwitter(String url) {

		Twitter lgbot = TwitterFactory.getSingleton();

		try {
			lgbot.updateStatus(url);
			ReceivePubSubMessage.LOGGER.info("Twitterに投稿しました");

		} catch (TwitterException e) {
			OutputTwitterException twitterError = new OutputTwitterException();
			twitterError.ouputLog(e);
		}
	}
}
