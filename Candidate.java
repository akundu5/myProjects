import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * this class holds all the basic information for candidates
 * it contains accessor and setter methods for all the information
 * The basic information includes name, years of experience in public office,
 * campaign slogan, significant issue stances, and recent news*/
public class Candidate{
  private String name;
  private int yearsOfExperience;
  private Map<String, Integer> yearsExperienceMap = new HashMap<String, Integer>();
  private String slogan;
  private ArrayList<String> stances;
  private String[] news;
  private int poll;
  private boolean novQual;
  private static ArrayList<String> ISSUES;
  //constructor for a call on the candidate class without any information
  //keeps name as an empty string and years experience as 0 till user updates those fields 
  public Candidate(){
    setName("");
    setTotalYearsExperience(0);
  }
  //constructor for a call on the candidate class with only name
  //yearsExperience is initialized as 0
  public Candidate(String name) {
    setName(name);
    setTotalYearsExperience(0);
  }
  //constructor for a call on the candidate class with name and years of experience
  public Candidate(String name, int years) {
    setName(name);
    setTotalYearsExperience(years);
  }
  //constructor for a call on the candidate class with all inputs given
  public Candidate(String name, String slogan, boolean qual,
      String[][]yearsExperience, String[] news) {
    setName(name);
    setYearsExperience(yearsExperience);
    setSlogan(slogan);
    //setIssues(issues);
    setNews(news);
    setNovQual(qual);
  }
  //setter method for candidate name
  public void setName(String name) {
    this.name = name;
  }
  //setter method for candidate's years of experience and how many years they spent in each
  //public office is saved in the form of a hashmap
  public void setYearsExperience(String[][] yearsExperience,int totalYears) {
    setTotalYearsExperience(totalYears);
    for(int i = 0; i < yearsExperience.length; i++) {
      yearsExperienceMap.put(yearsExperience[i][0], Integer.parseInt(yearsExperience[i][1]));
    }
  }
  //setter method for candidate's years of experience and how many years they spent in each
  //public office is saved in the form of a hashmap, this method is used in the same way as
  //setYearsExperience above but it is for those who don't input the totalYears
  //this program will use the info from the hashmap to calculate the totalyears
  public void setYearsExperience(String[][] yearsExperience) {
    int years = 0;
    for(int i = 0; i < yearsExperience.length; i++) {
      years += Integer.parseInt(yearsExperience[i][1]);
    }
    setTotalYearsExperience(years);
    for(int i = 0; i < yearsExperience.length; i++) {
      yearsExperienceMap.put(yearsExperience[i][0], Integer.parseInt(yearsExperience[i][1]));
    }
  }
  //setter method for candidate's total years of experience
  public void setTotalYearsExperience(int years) {
    this.yearsOfExperience = years;
  }
  //setter method for slogan
  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }
  //setter method for poll ranking
  public void setPoll(int poll) {
    this.poll = poll;
  }
  //setter method for issues/stances candidate is known for
  public void setStances(ArrayList<String> stances) {
    this.stances = new ArrayList<String>();
    this.stances.addAll(stances);
  }
  //setter method for the links to recent news candidate has been featured in 
  public void setNews(String[] news) {
    this.news = new String[3];
    for(int i = 0; i < this.news.length; i++) {
      this.news[i] = news[i];
    }
  }
  //setter method for issues list
  public void setIssues() {
    ISSUES = new ArrayList<String>();
    try {
      int i = 0;
      BufferedReader br;
      File file = new File("issues.txt");
      br = new BufferedReader(new FileReader(file));
      String s;
      while((s = (br.readLine())) != null) {
        ISSUES.add(i, s);
        i++;
      }
      br.close();
    }
    catch(IOException e) {
      System.out.println("File not found.");
    } 
  }
  //getter method for issues list
  public ArrayList<String> getIssues(){
    return ISSUES;
  }
  //setter method for boolean variable that expresses whether the candidate qualified for the next
  //debate in november
  public void setNovQual(boolean qual) {
    this.novQual = qual;
  }
  //returns candidate's name
  public String getName() {
    return this.name;
  }
  //returns candidate's yearsOfExperience
  public int getTotalYearsOfExperience(){
    return this.yearsOfExperience;
  }
  public HashMap<String, Integer> getYearsofExperience(){
    return (HashMap<String, Integer>)this.yearsExperienceMap;
  }
  //returns candidate's slogan
  public String getSlogan() {
    return this.slogan;
  }
  //returns candidate's poll standing
  public int getPoll() {
    return this.poll;
  }
  //returns candidate's highlighted/well-known stances on issues
  public ArrayList<String> getStances() {
    return this.stances;
  }
  //returns most recent news articles relating to candidate 
  public String[] getNews() {
    return this.news;
  }
  //getter method for boolean variable that expresses whether the candidate qualified for the next
  //debate in november
  public boolean getNovQual(boolean qual) {
    return this.novQual;
  }
  //prints all the information about the candidate 
//prints name
  public void printName() {
    
    System.out.print("Candidate Name: " + getName());
  }
    //prints total years of experience
  public void printYears() {
    System.out.println("Total Years of Experience: " + yearsOfExperience);
    System.out.println();
  }
  //prints a table of each office the candidate has held and for how many years
  public void printYearsOfExperience() {
    System.out.println("             OFFICE             |             YEARS             ");
    for (String office : this.yearsExperienceMap.keySet()) {
      System.out.printf("'%15s' %n", office + "|             " + yearsExperienceMap.get(office));
    }
    System.out.println();
  } 
  //prints candidate slogan
  public void printSlogan() {
    System.out.println("Slogan: " + getSlogan());
    System.out.println();
  }
  //prints candidate's poll standing
  public void printPoll() {
  
    System.out.println("Poll Standing: #" + getPoll());
    System.out.println(); 
  } 
  //prints recent news on candidate's campaign
  public void printNews() {
    System.out.println("Recent Media Coverage on Candidate: ");
    for(int i = 0; i < getNews().length; i++) {
      System.out.println(getNews()[i]);
    }
    System.out.println();
  }
  //prints main issues and stances candidate has
  public void printIssuesStances() {
    System.out.println("Main Issues/Stances: ");
    for(int i = 0; i < getIssues().size(); i++) {
      System.out.print(getIssues().get(i));
      System.out.print(": " + getStances().get(i));
      System.out.println();
    }
    System.out.println();
  }
  public void printAll() {
    printName();
    System.out.println();
    printYears();
    printYearsOfExperience();
    printSlogan();
    printPoll();
    printIssuesStances();
    printNews();
  }
}
