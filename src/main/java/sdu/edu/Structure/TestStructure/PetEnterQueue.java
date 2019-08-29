package sdu.edu.Structure.TestStructure;

public class PetEnterQueue {
	public Pet pet;
	public long count;
	public PetEnterQueue(Pet pet,long count){
		this.pet = pet;
		this.count = count;
	}
	public Pet getPet(){
		return this.pet;
	}
	public String getType(){
		return this.pet.getType();
	}
	public long getCount(){
		return this.count;
	}
}
