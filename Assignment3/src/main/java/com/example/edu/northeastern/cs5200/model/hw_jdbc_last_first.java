package com.example.edu.northeastern.cs5200.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.example.edu.northeastern.cs5200.dao.DeveloperDao;
import com.example.edu.northeastern.cs5200.dao.PageDao;
import com.example.edu.northeastern.cs5200.dao.PriviledgeDao;
import com.example.edu.northeastern.cs5200.dao.Roledao;
import com.example.edu.northeastern.cs5200.dao.UserDao;
import com.example.edu.northeastern.cs5200.dao.WebsiteDao;
import com.example.edu.northeastern.cs5200.dao.WidgetDao;

public class hw_jdbc_last_first {
	public hw_jdbc_last_first() {
		
	}

	public void runTest() throws ParseException {
		
		createDevelopers();
		createUsers();
		createWebsite();
		createPage();
		createWidget();
		/*implementUpdates();
		implementDeletes();*/
	}
	
	
	
	
	public void createUsers() throws ParseException{
		
		Collection<Address> danAddress= new ArrayList<>();
		danAddress.add(new Address(45, "dan-st1", "dan-st2", "dan-city", "dan-state", "012345", true));
		Collection<Phone>danPhone= new ArrayList<>();
		danPhone.add(new Phone(45, "543-453-213", true));
		User dan =new User(45, "Dan", "Martin", "dan", "dan", "dan@martin.com", null ,true);//
		UserDao.getInstance().createUser(dan);
		
		Collection<Address> edAddress= new ArrayList<>();
		edAddress.add(new Address(56,"ed-st1", "ed-st2", "ed-city", "ed-state", "654323", true));
		Collection<Phone>edPhone= new ArrayList<>();
		edPhone.add(new Phone(56,"765-321-723", true));
		User ed =new User(56, "Ed", "Karaz", "ed", "ed", "ed@kar.com", null ,true);//
		UserDao.getInstance().createUser(ed);
		

	} 
	public void createDevelopers() throws ParseException {
		
		//Alice
		Collection<Address>aliceAddress = new ArrayList<>();
		aliceAddress.add(new Address(12, "alice-st1", "alice-st2", "alice-city", "alice-state", "012345", true));
		Collection<Phone>alicePhone = new ArrayList<>();
		alicePhone.add(new Phone(12,"543-654-643", true));
		Developer alice = new Developer(12, "Alice","Wonder", "alice", "alice","alice@wonder.com", null, alicePhone, aliceAddress,"4321rewq"); // dateOfBirth 
		DeveloperDao.getInstance().createDeveloper(alice);
		//Bob
		Collection<Address> bobAddress = new ArrayList<>();
		bobAddress.add(new Address(23,"bob-st1", "bob-st2", "bob-city", "bob-state", "067890", true));

		Collection<Phone> bobPhone =  new ArrayList<>();
		bobPhone.add(new Phone(23,"754-654-623", true));
		Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com",null, bobPhone, bobAddress,"5432trew");
		DeveloperDao.getInstance().createDeveloper(bob);

		// Charlie
		Collection<Address> charlieAddress = new ArrayList<>();
		charlieAddress.add(new Address(34,"charlie-st1", "charlie-st2", "charlie-city", "charlie-state", "543224", true));
		
		Collection<Phone> charliePhone =  new ArrayList<>();
		charliePhone.add(new Phone(34,"453-564-123", true));
		Developer charlie = new Developer(34,"Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com", null, charliePhone, charlieAddress,"6543ytre");
		

	
				
		
				
			
		
	}
	
	
	public void createWebsite() {
		
		int aliceId = DeveloperDao.getInstance().findDeveloperByUsername("alice").getId();
		int bobId = DeveloperDao.getInstance().findDeveloperByUsername("bob").getId();
		int charlieId = DeveloperDao.getInstance().findDeveloperByUsername("charlie").getId();
		
		Website facebook = new Website("Facebook", 
				"an online social media and social networking service", 
				new Date(), new Date(), 1234234, null);
		createWebsiteInsert(facebook, aliceId, aliceId, bobId, charlieId);
		System.out.println("Created website Facebook.");
		
		Website twitter = new Website("Twitter", 
				"an online news and social networking service",
				new Date(), new Date(), 4321543, null);
		createWebsiteInsert(twitter, bobId, bobId, charlieId, aliceId);
		System.out.println("Created website Twitter");
		
		
		Website wikipedia = new Website("Wikipedia", 
				"a free online encyclopedia",
				new Date(), new Date(), 3456654, null);
		createWebsiteInsert(wikipedia, charlieId, charlieId, aliceId, bobId);
		System.out.println("Created website Wikipedia");
		

		Website cnn = new Website("CNN", 
				"an American basic cable and satellite television news channel",
				new Date(), new Date(), 6543345, null);
		createWebsiteInsert(cnn, aliceId, aliceId, bobId, charlieId);
		System.out.println("Created website CNN");
		
		Website cnet = new Website("CNET", 
				"an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",
				new Date(), new Date(), 5433455, null);
		createWebsiteInsert(cnet, bobId, bobId, charlieId, aliceId);
		System.out.println("Created website CNET");
		
		Website gizmodo = new Website("Gizmodo", 
				"a design, technology, science and science fiction website that also writes articles on politics",
				new Date(), new Date(), 4322345, null);
		createWebsiteInsert(gizmodo, charlieId, charlieId, aliceId, bobId);
		System.out.println("Created website Gizmodo");


	}

	public void createWebsiteInsert(Website website1, int developerId, 
			int owner, int editor, int admin) {
		
		int websiteId = WebsiteDao.getInstance().createWebsiteForDeveloper(developerId, website1);
		Roledao.getInstance().assignWebsiteRole(owner, websiteId, Role.OWNER.getIndex());
		Roledao.getInstance().assignWebsiteRole(editor, websiteId, Role.EDITOR.getIndex());
		Roledao.getInstance().assignWebsiteRole(admin, websiteId, Role.ADMIN.getIndex());
		
	}
	
	
	
	public void createPage() {
		int aliceId = DeveloperDao.getInstance().findDeveloperByUsername("alice").getId();
		int bobId = DeveloperDao.getInstance().findDeveloperByUsername("bob").getId();
		int charlieId = DeveloperDao.getInstance().findDeveloperByUsername("charlie").getId();

		int cnetId = 0, gizmodoId = 0, wikipediaId = 0, cnnId = 0;
		Collection<Website> websiteList = WebsiteDao.getInstance().findAllWebsites();
		
		for (Website website : websiteList) {
			String name = website.getName().toLowerCase();
			if (name.equals("cnet")) {
				cnetId = website.getId();
			} else if (name.equals("cnn")) {
				cnnId = website.getId();
			} else if (name.equals("wikipedia")) {
				wikipediaId = website.getId();
			} else if (name.equals("gizmodo")) {
				gizmodoId = website.getId();
			}
		}
		
		
		Page home = new Page(123,"Home", "Landing page", new Date(), new Date(), 123434, null);
		createPageInsert(home, cnetId, aliceId, bobId, charlieId);
		

		Page about = new Page(234,"About", "Website description", new Date(), new Date(), 234545, null);
		createPageInsert(about, gizmodoId, bobId, charlieId, aliceId);
		
		
		Page contact = new Page(345,"Contact", "Addresses, phones, and contact info", new Date(), new Date(), 345656, null);
		createPageInsert(contact, wikipediaId, charlieId, aliceId, bobId);
		
		
		Page preferences = new Page(456,"Preferences", "Where users can configure their preferences", new Date(), new Date(), 456776, null);
		createPageInsert(preferences, cnnId, aliceId, bobId, charlieId);
		
		
		Page profile = new Page(567,"Profile",
				"Users can configure their personal information",
				new Date(), new Date(), 567878, null);
		createPageInsert(profile, cnetId, bobId, charlieId, aliceId);
		
		
	}
	
	
	
	public void createPageInsert(Page page1, int websiteId, int editor, int reviewer, int writer) {
		
		int pageId = PageDao.getInstance().createPageForWebsite(websiteId,page1);
		
		Roledao.getInstance().assignPageRole(editor, pageId,Role.EDITOR.getIndex());
		Roledao.getInstance().assignPageRole(reviewer, pageId, Role.REVIEWER.getIndex());
		Roledao.getInstance().assignPageRole(writer, pageId, Role.WRITER.getIndex());
				
	}
	
	
	
	public void createWidget() {
		int homePageId = 0, aboutPageId = 0, contactPageId = 0, preferencesPageId = 0;
		Collection<Page> pageList = PageDao.getInstance().findAllPages();
		for(Page p : pageList) {
			String pageTitle = p.getTitle().toLowerCase();
			if (pageTitle.equals("home")) {
				homePageId = p.getId();
			} else if(pageTitle.equals("about")) {
				aboutPageId = p.getId();
			} else if(pageTitle.equals("contact")) {
				contactPageId = p.getId();
			} else if(pageTitle.equals("preferences")) {
				preferencesPageId = p.getId();
			}
		}
		// id, name,width, height,cssClass,cssStyle,text,order
		
		
		Widget head123 = new HeadingWidget(123,"head123",0, 0, "null", "null", "Welcome",1,0);
		WidgetDao.getInstance().createWidgetForPage(homePageId, head123);
		
		
		Widget post234 = new HtmlWidget(234,"post234", 0, 0, "null", "null", "lorem ipsum", 0, "<p>Lorem</p>");
		WidgetDao.getInstance().createWidgetForPage(aboutPageId, post234);
		
		
		
		Widget head345 = new HeadingWidget(345,"head345", 0, 0, null, null, "Hi", 1, 0);
		WidgetDao.getInstance().createWidgetForPage(contactPageId, head345);
		
		
		
	    Widget intro456 = new HtmlWidget(456, "intro456", 0, 0, null, null, "lorem ipsum", 2, "<h1>Hi</h1>");
		WidgetDao.getInstance().createWidgetForPage(contactPageId, intro456);
		
		
		
		Widget image345 = new ImageWidget(345,"image345", 100, 50, null, null, "alt text", 3, "/img/567.png");
		WidgetDao.getInstance().createWidgetForPage(contactPageId, image345);
		
		
		
		Widget video456 = new YoutubeWidget(456, "video456", 300, 400, null, null, "alt-text", 0, "https://youtu.be/h67VX51QXiQ", true, true);
		WidgetDao.getInstance().createWidgetForPage(preferencesPageId, video456);
		
		
	}
	


  
	
	
	
	

}
