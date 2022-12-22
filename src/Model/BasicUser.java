
package Model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Vector;


import Config.*;

public class BasicUser implements User, Comparable<BasicUser>, Cloneable , Serializable{
    
    public String firstLastName;
    private int id;
    public String login;
    private long hashOfPassword;
    public boolean loginStatus;
    private LocalDateTime registerDate;

    public boolean isResearcher;
    public int hIndex;
    public Vector<String> researchPapers = new Vector<String>();
    public Vector<String> researchProjects = new Vector<String>();
    
	private static int count = 0;
	
	{
		hIndex = -1;
		BasicUser.count++;
		this.loginStatus = false;
		this.isResearcher = false;
	}

    
    public BasicUser() {

    }
    
    public BasicUser(String firstLastName) {
    	this.firstLastName = firstLastName;
    	this.id = count;
    	this.login = generateDefaultLogin(firstLastName);
    	this.setPassword("AnyPassword1");
    	this.registerDate = LocalDateTime.now();
    	
    }
    
    public BasicUser(String firstLastName, String password) {
    	this(firstLastName);
        this.setPassword(password);
    }
    
    public BasicUser(String firstLastName, String login, String password) {
        this(firstLastName, password);
    	this.id = count;
        this.login = login;
        
    }

    public BasicUser(String firstLastName, String login, String password, boolean isResearcher) {
        this(firstLastName, login, password);
        this.isResearcher = isResearcher;
    }


    
	public int getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}

	public boolean getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
    
    
    

    //                          Operations    

    protected String generateDefaultLogin(String name) {
		return name.replaceAll(" ", "").toLowerCase();
    }
	
    protected void setPassword(String password) {
		this.hashOfPassword = hashingPassword(password);
	}
	
	private static long hashingPassword(String password) {
		final int P = 227;
		final long MOD = (long) 1e18;
		long hash = 0;
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			hash = ((hash * P) % MOD + (int)c) % MOD;
		}
		return hash;
	}


	@Override
	public boolean authenticate(String login, String password) {
		for (User user: Database.users) {
			if (user instanceof BasicUser) {
				BasicUser basicUser = (BasicUser)user;
				if (basicUser.getLogin() == login) {
					if (basicUser.getHashOfPassword() == hashingPassword(password)) {
						loginStatus = true;
						return true;
					}
					System.out.println("You provided uncorrect password");
					return false;
				}
			}
		}
		System.out.println("You are not in the system, please go to admin to add you / sign up you");
		return false;
	}

	@Override
	public boolean changePassword(String oldPassword, String newPassword) {
		if (hashingPassword(oldPassword) == getHashOfPassword()) {
			if (validatePassword(newPassword)) {
				setPassword(newPassword);
				return true;
			}
			return false;
		}
		return false;
	}
	
	
	protected  boolean validatePassword(String password) {
		return password.length() >= 8 && 
				containsDigit(password) && 
				password != password.toLowerCase() && 
				password != password.toUpperCase();
	}
	
	
	private boolean containsDigit(String password) {
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	protected long getHashOfPassword() {
		return this.hashOfPassword;
	}

	@Override
    public void writeCommentInNews(String text, News news) {
    	Comment com = new Comment(this, text);
    	News.writeNewsComment(com, news);
    }

	@Override
    public Vector<News> viewNews() {
        return News.news;
    }
	
	
	
	
	public String toString() {
		return "Username: " + firstLastName + ", login: " + login + ", login status: " + loginStatus + ", register date: " + registerDate; 
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		
		BasicUser basicUser = (BasicUser) o;
		return basicUser.id == this.id && 
				basicUser.hashOfPassword == this.hashOfPassword && 
				basicUser.isResearcher == this.isResearcher && 
				basicUser.firstLastName.equals(this.firstLastName) && 
				basicUser.login.equals(this.login) && 
				basicUser.registerDate.equals(this.registerDate);
	}
	
	public int hashCode() {
		return Objects.hash(id, hashOfPassword, 
				isResearcher, firstLastName, 
				login, registerDate);
	}
	
	public int compareTo(BasicUser user) {
		if (this.id < user.id) {
			return -1;
		}
		else if (this.id > user.id) {
			return 1;
		}
		return 0;
	}
	
	public Object clone() throws CloneNotSupportedException {
		BasicUser newUser = new BasicUser();
		newUser.id = this.id;
		newUser.hashOfPassword = this.hashOfPassword;
		newUser.isResearcher = this.isResearcher;
		newUser.firstLastName = this.firstLastName;
		newUser.login = this.login;
		newUser.registerDate = this.registerDate;
		return newUser;
	}

	@Override
	public boolean doResearch() {
		if (isResearcher == false) {
			System.out.println("Basic User who is not researcher cannot research");
			return false;
		}
		else {
			System.out.println("You can make project/paper");
			return true;
		}
	}

	@Override
	public boolean addResearchPaper(String paper) {
		if (isResearcher == true) {
			return this.researchPapers.add(paper);
		}
		else {
			System.out.println("You r not researcher");
			return false;
		}
	}

	@Override
	public boolean addResearchProject(String project) {
		if (isResearcher == true) {
			return this.researchProjects.add(project);
		}
		else {
			System.out.println("You r not researcher");
			return false;
		}
	}
	
	
	
}
