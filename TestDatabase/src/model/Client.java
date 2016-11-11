package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Client implements List<Client> {
String clientName,address,currency;

public String getClientName() {
	return clientName;
}

public void setClientName(String clientName) {
	this.clientName = clientName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCurrency() {
	return currency;
}

public void setCurrency(String currency) {
	this.currency = currency;
}

@Override
public boolean add(Client arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void add(int index, Client element) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean addAll(Collection<? extends Client> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean addAll(int index, Collection<? extends Client> c) {
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
public Client get(int index) {
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
public Iterator<Client> iterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int lastIndexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public ListIterator<Client> listIterator() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ListIterator<Client> listIterator(int index) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Client remove(int index) {
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
public Client set(int index, Client element) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<Client> subList(int fromIndex, int toIndex) {
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
