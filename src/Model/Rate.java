package Model;

import java.io.Serializable;
import java.util.Objects;

public class Rate implements Comparable<Rate>, Cloneable , Serializable{
	public double value;
	public int count;
	
	public Rate() {
		this.value = 0;
		this.count = 0;
	}
	
	public Rate(double value, int count) {
		this.value = value;
		this.count = count;
	}
	
	public String toString() { 
		return "value: " + value + ", count: " + count;
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
		Rate r = (Rate)o;
		return r.count == this.count && r.value == this.value;
	}
	
	public int hashCode() {
		return Objects.hash(value, count);
	}
	
	public Object clone() {
		Rate newRate = new Rate();
		newRate.value = this.value;
		newRate.count = this.count;
		return newRate;
	}

	@Override
	public int compareTo(Rate rate) {
		if (this.value < rate.value) {
			return -1;
		}
		else if (this.value > rate.value) {
			return 1;
		}
		return 0;
	}
}
