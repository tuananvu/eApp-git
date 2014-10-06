package com.rknowsys.eapp;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rknowsys.eapp.hrm.model.Location;

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

Location instance1 = (Location) obj1;
Location instance2 = (Location) obj2;


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
