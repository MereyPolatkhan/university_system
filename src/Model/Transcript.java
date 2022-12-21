package Model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;


public class Transcript implements Cloneable, Serializable {

	public Vector<Attestation> attestations;
	
	public Transcript() {
		attestations = new Vector<Attestation>();
	}
	
	public Transcript(Vector<Attestation> attestations) {
		this.attestations = attestations;
	}
	
	
	public static double standardDeviation(Vector<Double> numbers, double mean) {
		double result = 0;
		double sumSquare = 0;
		int n = numbers.size();
		for (double d: numbers) {
			sumSquare += ((d - mean) * (d - mean));
		}
		result = Math.sqrt(sumSquare / (n - 1));
		return result;
	}
	
	public String toString() {
		return "Transcript attestations: " + this.attestations;
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Transcript t = (Transcript)o;
		
		return this.attestations.equals(t.attestations);
	}
	
	public int hashCode() {
		return Objects.hash(attestations);
	}
	
	
	public Object clone() throws CloneNotSupportedException {
		Transcript newTranscript = new Transcript();
		for (Attestation att: this.attestations) {
			newTranscript.attestations.add((Attestation) att.clone());
		}
		 
		return newTranscript;
	}
}
