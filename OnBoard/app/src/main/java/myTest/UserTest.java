package myTest;

import android.test.InstrumentationTestCase;

import com.example.taqtile.onboard.User2;

/**
 * Created by taqtile on 1/11/16.
 */
public class UserTest extends InstrumentationTestCase {

    private Integer mId = 1;
    private String mFirstName = "Lindsay";
    private String mLastName = "Sirus";
    private String mUrl = "http://anyurl.com";

    public void test() throws Exception {


        User2 user= new User2(mId, mFirstName,mLastName, mUrl );
        String realFirstName = user.getFirstName();
        String realLastName = user.getLastName();
        String realUrl = user.getAvatar();
        Integer realId = user.getId();

        user.addCounter();
        user.addCounter();
        user.addCounter();

        Integer count = user.getCounter();
        Integer expected = 3;
       // assertEquals(expected, reality);

        assertEquals(mId, realId);
        assertEquals(mFirstName, realFirstName);
        assertEquals(mLastName,realLastName);
        assertEquals(mUrl,realUrl);
        assertEquals(expected,count);
    }
}
