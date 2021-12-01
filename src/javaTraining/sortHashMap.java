package javaTraining;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * Sort Map based on Values in java
 * @author KK JavaTutorials
 *
 */
public class sortHashMap {

	public static void main(String[] args) {
		
		Map<Character,Integer> map = new HashMap<>();
		
		map.put('a', 5);
		map.put('c', 5);
		map.put('b', 2);
		map.put('m', 1);
		System.out.println("Original:::::::::");
		map.forEach((k,v)->System.out.println(k+"\t"+v));
		List<Entry<Character,Integer>> list= new ArrayList<>(map.entrySet());
		Collections.sort(list, (o1,o2)->o1.getValue().compareTo(o2.getValue()));
		

		System.out.println("Original:::::::::");
		list.forEach(elt->System.out.println(elt.getKey()+"\t"+elt.getValue()));
		
		
		
		
		
		
		
		
		
		
		
		
		/*System.out.println("Original Map::::");
		map.forEach((k,v)->System.out.println(k+"\t"+v));
		
		Set<Entry<Character,Integer>> entrySet = map.entrySet();
		
		List<Entry<Character,Integer>> list = new ArrayList<>(entrySet);
		
		Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		
		System.out.println("Map sorted based on Values::::");
		
		list.forEach(s->{
			System.out.println(s.getKey()+"\t"+s.getValue());
		});*/
	}
}