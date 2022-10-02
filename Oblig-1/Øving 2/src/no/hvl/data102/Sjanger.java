package no.hvl.data102;


public enum Sjanger {
	FANTASY, HISTORY, ACTION, DRAMA;
	
	

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjng = null;
		for (Sjanger sja : Sjanger.values()) {
			if (sja.toString().equals(navn.toUpperCase())) {
				sjng = sja;
				break;
			}

		}
		return sjng;

	}

}
