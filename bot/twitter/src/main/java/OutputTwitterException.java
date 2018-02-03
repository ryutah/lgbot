import java.util.logging.Logger;

import twitter4j.TwitterException;

/**
 * エラー内容をログに出力するクラス
 * @author kazuki
 *
 */

public class OutputTwitterException {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	private int errorCode;
	private String ErrorMessage;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	/**
	 * TwitterExceptionの内容をログ出力する。
	 * @param e
	 * 		TwitterExceptionの例外変数
	 */
	public void ouputLog(TwitterException e) {

		int errorCode = e.getErrorCode();
		String errorMessage = ErrorConstants.ExceptionContentsMaster.get(errorCode);

		LOGGER.info(String.valueOf(errorCode) + errorMessage);

	}
}
