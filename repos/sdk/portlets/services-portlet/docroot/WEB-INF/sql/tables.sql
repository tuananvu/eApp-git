create table hrm_Attachment (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table hrm_ContactDetails (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	addressStreet1 VARCHAR(75) null,
	addressStreet2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	postalCode VARCHAR(75) null,
	country VARCHAR(75) null,
	homeTelephone VARCHAR(75) null,
	mobile VARCHAR(75) null,
	workTelephone VARCHAR(75) null,
	workEmail VARCHAR(75) null,
	otherEmail VARCHAR(75) null
);

create table hrm_Dependent (
	dependentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table hrm_EmergencyContact (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table hrm_Immigration (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table hrm_Qualification (
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table hrm_work_shift (
	shiftId LONG not null,
	workShiftUserId LONG not null,
	primary key (shiftId, workShiftUserId)
);

create table job_category (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userId LONG,
	jobcategory VARCHAR(75) null
);

create table job_titles (
	id_ LONG not null primary key,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userId LONG,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	notes VARCHAR(75) null,
	specification VARCHAR(75) null
);