package mock;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-01-14
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MockMainTest {


    public static void main(String[] args) {


        MockInterface mockInterface =  new MockInterface(){
            @Override
            public boolean lock() {
                return false;
            }

            @Override
            public boolean unLock() {
                return false;
            }
        };



       MockTest mt =  new MockTest(){

           @Override
           public boolean lock() {
               return super.lock();
           }

           @Override
           public boolean unLock() {
               return super.unLock();
           }
       };

    }
}
