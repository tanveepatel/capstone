package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FileData implements List<FileData> {
	String date,fname,lname,project,houre;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
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
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getHoure() {
		return houre;
	}
	public void setHoure(String houre) {
		this.houre = houre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int id;


	public String toString() {
		return "Resource [id=" + this.id + "date="+this.date+", fname=" + this.fname+ 
				", lname="+ this.lname+", project="+this.project+" hourse="+this.houre+"]";
	}
	@Override
	public boolean add(FileData arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void add(int arg0, FileData arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean addAll(Collection<? extends FileData> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addAll(int arg0, Collection<? extends FileData> arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public FileData get(int index) {
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
	public Iterator<FileData> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator<FileData> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator<FileData> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public FileData remove(int index) {
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
	public FileData set(int index, FileData element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<FileData> subList(int fromIndex, int toIndex) {
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
