package sdu.edu.Structure.FStructure.CatDog;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
	public Queue<PetEnterQueue> qcat;
	public Queue<PetEnterQueue> qdog ;
	public long count ;
	public CatDogQueue(){
		qcat = new LinkedList<>();
		qdog = new LinkedList<>();
		count = 0;
	}
	public void add(Pet pet){
		if(pet.getType().equals("cat")){
			qcat.add(new PetEnterQueue(pet, this.count++));
		}else if(pet.getType().equals("dog")){
			qdog.add(new PetEnterQueue(pet, this.count++));
		}
	}
	public Pet pollAll(){
		if(!qcat.isEmpty() && !qdog.isEmpty()){
			if(qcat.peek().getCount() < qdog.peek().getCount()){
				return qcat.poll().getPet();
			}else{
				return qdog.poll().getPet();
			}
		}else if(!qcat.isEmpty()){
			return qcat.poll().getPet();
		}else if(!qdog.isEmpty()){
			return qdog.poll().getPet();
		}else{
			throw new RuntimeException("error");
		}
	}
	
	public Pet pollCat(){
		if(!qcat.isEmpty()){
			return qcat.poll().getPet();
		}else{
			throw new RuntimeException("error");
			}
	}
	
	public Pet pollDog(){
		if(!qdog.isEmpty()){
			return qdog.poll().getPet();
		} else {
			throw new RuntimeException("error");
		}
	}
	
	public boolean isEmpty(){
		return qdog.isEmpty() && qcat.isEmpty();
	}
	public boolean isCatEmpty(){
		return qcat.isEmpty();
	}
	
	public boolean  isDogEmpty(){
		return qdog.isEmpty();
	}
}
