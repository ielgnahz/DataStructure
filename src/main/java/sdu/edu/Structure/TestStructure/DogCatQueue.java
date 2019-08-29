package sdu.edu.Structure.TestStructure;

import java.util.LinkedList;
import java.util.Queue;


public class DogCatQueue {
	public Queue<PetEnterQueue> dogq;
	public Queue<PetEnterQueue> catq;
	public int count;
	
	public DogCatQueue(){
		this.dogq = new LinkedList<PetEnterQueue>();
		this.catq = new LinkedList<>();
		this.count = 0;
	}
	
	public void add(Pet pet){
		if(pet.getType().equals("cat")){
			this.catq.add(new PetEnterQueue(pet, this.count++));
		}else if(pet.getType().equals("dog")){
			this.dogq.add(new PetEnterQueue(pet, this.count++));
		}else{
			throw new RuntimeException("error,no dog or cat");
		}
	}
	public Pet pollAll(){
		if(!dogq.isEmpty() && !catq.isEmpty()){
			if(dogq.peek().getCount() < catq.peek().getCount()){
				return dogq.poll().getPet();
			}else{
				return catq.poll().getPet();
			}
		}else if(!dogq.isEmpty()){
			return dogq.poll().getPet();
		}else if(!catq.isEmpty()){
			return catq.poll().getPet();
		}else{
			return null;
		}
	}
}
