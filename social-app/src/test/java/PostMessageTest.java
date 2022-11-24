import java.util.Scanner;

import com.kvcet.socialapp.dao.PostDao;
import com.kvcet.socialapp.dao.impl.PostDaoImpl;
import com.kvcet.socialapp.model.Post;
import com.kvcet.socialapp.service.PostService;
import com.kvcet.socialapp.service.impl.PostServiceImpl;

public class PostMessageTest {

	public static void main(String[] args) throws Exception {
		postMessage();

	}

	public static void postMessage() throws Exception {

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter a user id:");
		int id = sc.nextInt();
		int a = 0;
		System.out.println("Enter a message:");
		String message = sc1.nextLine();

		Post post = new Post();
		post.setUserId(id);
		post.setMessage(message);

		PostService ps = new PostServiceImpl();
		PostDao pd = new PostDaoImpl();
		
		a=ps.postMessageValidation(post);
		
		if(a==1) {
			pd.postMessage(post);
		}

	}

}
