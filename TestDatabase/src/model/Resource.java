package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Resource implements List<Resource> {
	String fname,lname,email,department,permissions;
	public static String test="piyush";
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public String getBillRate() {
		return billRate;
	}
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}
	public String getCostRate() {
		return costRate;
	}
	public void setCostRate(String costRate) {
		this.costRate = costRate;
	}
	String billRate;
	String costRate;

	public String toString() {
		return "Resource [fname=" + this.fname + ", lname=" + this.lname+ 
				", email="+ this.email+", department="+this.billRate+" billRate="+this.billRate+
				" costRate="+this.costRate+"permission="+this.permissions+"]";
	}
	@Override
	public boolean add(Resource arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void add(int index, Resource element) {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean addAll(Collection<? extends Resource> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int index, Collection<? extends Resource> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Resource get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Iterator<Resource> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<Resource> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator<Resource> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Resource remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Resource set(int index, Resource element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<Resource> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}    

}
