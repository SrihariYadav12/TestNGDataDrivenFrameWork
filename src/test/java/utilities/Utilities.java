package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Utilities {
	
	
	public static void robotClass(String ImgPath) {
//		1)Copy Path of file
//		2)CTRL+V
//		3)Enter key on the keyboard

		try {
			Robot rb = new Robot();
			rb.delay(2000);

			// put path to file in a clipboard
			StringSelection ss = new StringSelection(ImgPath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// CTRL+V
			rb.keyPress(KeyEvent.VK_CONTROL);// press on CTRL key on your keyboard
			rb.keyPress(KeyEvent.VK_V);

			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);

			// ENTER
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {

			e.printStackTrace();
		}
	}


}
