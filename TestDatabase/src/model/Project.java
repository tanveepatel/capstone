package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Project implements List<Project> {
String client,projectName,projectCode,
dateStart,dateEnd,notes,invoiceMethod,budget,permissions,team;

public String getClient() {
	return client;
}

public void setClient(String client) {
	this.client = client;
}

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public String getProjectCode() {
	return projectCode;
}

public void setProjectCode(String projectCode) {
	this.projectCode = projectCode;
}

public String getDateStart() {
	return dateStart;
}

public void setDateStart(String dateStart) {
	this.dateStart = dateStart;
}

public String getDateEnd() {
	return dateEnd;
}

public void setDateEnd(String dateEnd) {
	this.dateEnd = dateEnd;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

public String getInvoiceMethod() {
	return invoiceMethod;
}

public void setInvoiceMethod(String invoiceMethod) {
	this.invoiceMethod = invoiceMethod;
}

public String getBudget() {
	return budget;
}

public void setBudget(String budget) {
	this.budget = budget;
}

public String getPermissions() {
	return permissions;
}

public void setPermissions(String permissions) {
	this.permissions = permissions;
}

public String getTeam() {
	return team;
}

public void setTeam(String team) {
	this.team = team;
}

@Override
public boolean add(Project e) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void add(int index, Project element) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean addAll(Collection<? extends Project> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean addAll(int index, Collection<? extends Project> c) {
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
public Project get(int index) {
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
public Iterator<Project> iterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int lastIndexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public ListIterator<Project> listIterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ListIterator<Project> listIterator(int index) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Project remove(int index) {
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
public Project set(int index, Project element) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<Project> subList(int fromIndex, int toIndex) {
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
