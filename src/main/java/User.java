/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 9:34
 * 4
 */
@SetTable(value = "user")
public class User {

   @SetProperty(name = "user_id",leng = 10)
    private String userId;
    @SetProperty(name = "user_name",leng = 10)
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
