package Chemical_Element;

import java.util.Arrays;

public class ChemicalElement {
	
	private static final Boolean TRUE = null;
	private String name;
	private String symbolicName;
	private int atomicNumber;
	private boolean isAlkali;
	private boolean isTransition;
	private boolean isMetalsare;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbolicName() {
		return symbolicName;
	}
	public void setSymbolicName(String symbolicName) {
		this.symbolicName = symbolicName;
	}
	public int getAtomicNumber() {
		return atomicNumber;
	}
	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}
	
	public boolean isAlkali(int atomicNum) {
		boolean isAlkali = false;
		switch (atomicNum) {
			case 3 : 
			case 11:
			case 19:
			case 37:
			case 55:
			case 87:
			isAlkali = true;
		}
		return isAlkali;
	}
	
	public boolean isTransition(int atomicNum) {
		Boolean[] isMetal = new Boolean[113];
		Arrays.fill(isMetal, Boolean.FALSE);
		
		for(int i=21;i<=31;i++) {
			isMetal[i] = TRUE;
		}
		for(int i=39;i<=48;i++) {
			isMetal[i] = TRUE;
		}
		for(int i=72;i<=80;i++) {
			isMetal[i] = TRUE;
		}
		for(int i=104;i<=112;i++) {
			isMetal[i] = TRUE;
		}
		return isMetal[atomicNum] == TRUE;
	}
	
	public boolean isMetal(int atomNum) {
		return (atomNum==13 || atomNum==49 || atomNum==50 || atomNum==81 || atomNum==82 || atomNum==83
				|| atomNum==113 || atomNum==114 || atomNum==115 || atomNum==116);
	}
	

}
