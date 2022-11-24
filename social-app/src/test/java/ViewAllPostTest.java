import com.kvcet.socialapp.dao.PostDao;
import com.kvcet.socialapp.dao.impl.PostDaoImpl;

public class ViewAllPostTest {

	public static void main(String[] args) {
		viewAllPost();
	}

	public static void viewAllPost() {

		PostDao pd = new PostDaoImpl();
		pd.viewAllPost();

	}

}
