import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class HashMapCreator<T> {
  private ArrayList<T> value;
  private ArrayList<Candidate> key;
  private HashMap<Candidate, T> map;
  public HashMapCreator(ArrayList<Candidate> key, ArrayList<T> value) {
    this.key = new ArrayList<Candidate>();
    this.value = new ArrayList<T>();
    this.key.addAll(key);
    this.value.addAll(value);
  }
  public HashMap<Candidate, T> createMap(){
    map = new HashMap<Candidate, T>();
    for(int i = 0; i < this.key.size(); i++) {
      this.map.put(key.get(i), value.get(i));
    }
    return map;
  }
  public void printMap(String title) {
    System.out.println(title);
    for(Candidate name: map.keySet()) {
      System.out.println(name.getName() + ": " + map.get(name));
    }
  }
  public ArrayList<Candidate> getPYes() {
    ArrayList<Candidate> list = new ArrayList<Candidate>();
    for(Candidate name: map.keySet()) {
      if(map.get(name).equals("PLANNED PRIORITY PRO")) {
        list.add(name);
      }
    }
    return list;
  }
  public ArrayList<Candidate> getPNo() {
    ArrayList<Candidate> list = new ArrayList<Candidate>();
    for(Candidate name: map.keySet()) {
      if(map.get(name).equals("PLANNED PRIORITY ANTI")) {
        list.add(name);
      }
    }
    return list;
  }
  public ArrayList<Candidate> getYes() {
    ArrayList<Candidate> list = new ArrayList<Candidate>();
    for(Candidate name: map.keySet()) {
      if(map.get(name).equals("PRO")) {
        list.add(name);
      }
    }
    return list;
  }
  public ArrayList<Candidate> getNo() {
    ArrayList<Candidate> list = new ArrayList<Candidate>();
    for(Candidate name: map.keySet()) {
      if(map.get(name).equals("ANTI")) {
        list.add(name);
      }
    }
    return list;
  }
  public ArrayList<Candidate> getUnclear() {
    ArrayList<Candidate> list = new ArrayList<Candidate>();
    for(Candidate name: map.keySet()) {
      if(map.get(name).equals("UNCLEAR")) {
        list.add(name);
      }
    }
    return list;
  }
//  @Override
//  public Iterator<Candidate> iterator() {
//    // TODO Auto-generated method stub
//    return new MapIterator<Candidate>(key);
//  }
  public void printAll(String title) {
    printMap(title);
    System.out.println("Number of Planned Priority Pro: " + getPYes().size());
    System.out.println("Number of Planned Priority Anti: " + getPNo().size());
    System.out.println("Number of Pro: " + getYes().size());
    System.out.println("Number of Anti: " + getNo().size());
    System.out.println("Number of Unclear: " + getUnclear().size());
  }
}
