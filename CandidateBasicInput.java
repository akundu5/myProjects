import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CandidateBasicInput {
  private static ArrayList<Candidate> candidates = new ArrayList<Candidate>();
  public static void JoeBiden(){
    String name = "Joseph R. Biden Jr.";
    String[][] years = new String[][] {{"Delaware Senator", "36"}, {"Vice President", "8"}};
    String slogan = "Our Best Days Still Lie Ahead";
    boolean qual = true;
    int poll = 1;
    ArrayList<String> issues = new ArrayList<String>();
    BufferedReader br; 
    try {
      File file = new File("JoeBiden.txt");
      br = new BufferedReader(new FileReader(file));
      int i = 0;
      String s;
      while((s = (br.readLine())) != null) {
        issues.add(i, s);
        i++;
      }
      i = 0;
      br.close();
    }
    catch(IOException e) {
      System.out.println("File not found.");
    }
    String[] news = new String[3];
    news[0] = "https://www.nytimes.com/2019/10/26/us/politics/joe-biden-campaign-fundraising.html";
    news[1] = "https://nypost.com/2019/10/26/brother-of-sandy-hook-victim-calls-out-biden-for-"
        + "lying-in-campaign-ad/";
    news[2] = "https://www.washingtonpost.com/politics/ap-interview-biden-confident-of-prospects-"
        + "in-south-carolina/2019/10/26/54ef6f20-f816-11e9-b2d2-1f37c9d82dbb_story.html";
    Candidate JoeBiden = new Candidate(name, slogan, qual, years, news);
    JoeBiden.setIssues();
    JoeBiden.setPoll(poll);
    JoeBiden.setStances(issues);
    candidates.add(JoeBiden);
  }
  public static void ElizabethWarren(){
    String name = "Elizabeth Warren";
    String[][] years = new String[][] {{"Delaware Senator", "36"}, {"Vice President", "8"}};
    String slogan = "Our Best Days Still Lie Ahead";
    boolean qual = true;
    int poll = 1;
    ArrayList<String> issues = new ArrayList<String>();
    BufferedReader br; 
    try {
      File file = new File("JoeBiden.txt");
      br = new BufferedReader(new FileReader(file));
      int i = 0;
      String s;
      while((s = (br.readLine())) != null) {
        issues.add(i, s);
        i++;
      }
      i = 0;
      br.close();
    }
    catch(IOException e) {
      System.out.println("File not found.");
    }
    String[] news = new String[3];
    news[0] = "https://www.nytimes.com/2019/10/26/us/politics/joe-biden-campaign-fundraising.html";
    news[1] = "https://nypost.com/2019/10/26/brother-of-sandy-hook-victim-calls-out-biden-for-"
        + "lying-in-campaign-ad/";
    news[2] = "https://www.washingtonpost.com/politics/ap-interview-biden-confident-of-prospects-"
        + "in-south-carolina/2019/10/26/54ef6f20-f816-11e9-b2d2-1f37c9d82dbb_story.html";
    Candidate ElizabethWarren = new Candidate(name, slogan, qual, years, news);
    ElizabethWarren.setIssues();
    ElizabethWarren.setPoll(poll);
    ElizabethWarren.setStances(issues);
    candidates.add(ElizabethWarren);    
  }
  public static void createIssueMap(int issueNum) {
    ArrayList<String> issueStances = new ArrayList<String>();
    for(int i = 0; i < candidates.size(); i++) {
      issueStances.add(i, candidates.get(i).getStances().get(issueNum));
    }
    HashMapCreator<String> issueMap = new HashMapCreator<String>(candidates, issueStances);
    String title = candidates.get(0).getIssues().get(issueNum);
    issueMap.createMap();
    issueMap.printAll(title);
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    JoeBiden();
    ElizabethWarren();
    System.out.println("Candidates: ");
    for(int i = 0; i < candidates.size(); i++) {
      System.out.println((i+1) + ". " + candidates.get(i).getName());
    }
    int num = 100;
    while(num != 0) {
      System.out.println("If you want to know more about a candidate, enter their number, otherwise"
          + " enter 0 to continue.");
      num = input.nextInt();
      if(num != 0) {
        candidates.get(num - 1).printAll();
      }
    }
    num = 100;
    while(num != 0) {
      System.out.println("If you want to know more about where all the candidates stand on issues,"
          + " enter the issue number you'd like to see the distribution for, "
          + "or enter 0 to continue.");
      num = input.nextInt();
      if(num != 0) {
        createIssueMap(num - 1);
      }
    }
  }
}
