package sdu.edu.Structure.FStructure.CatDog;

public class PetEnterQueue {
	public Pet pet;
	public long count;
	public PetEnterQueue(Pet pet,long count){
		this.pet = pet;
		this.count = count;
	}
	public long getCount(){
		return count;
	}
	public Pet getPet(){
		return pet;
	}
	public String getPetType(){
		return pet.getType();
	}
}
