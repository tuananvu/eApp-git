package com.test;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.model.Locations;

public class LocationsComparator extends OrderByComparator{
	private static final long serialVersionUID = 1L;

public static String ORDER_BY_ASC = "status ASC";

public static String ORDER_BY_DESC = "status DESC";

public LocationsComparator()
{
this(false);
}

public LocationsComparator(boolean asc) {
_asc = asc;
}



public int compare(Object obj1, Object obj2) {

Locations instance1 = (Locations) obj1;
Locations instance2 = (Locations) obj2;


int value = instance1.getName().toLowerCase().compareTo(instance2.getName().toLowerCase());

if(_asc)
{
return value;
} else
{
return -value;
}

}


public String getOrderBy() {

if (_asc) {
return ORDER_BY_ASC;
}
else {
return ORDER_BY_DESC;
}
}

private boolean _asc;



}
