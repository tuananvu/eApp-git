create table hrm_Job (
	jobId LONG not null primary key,
	jobTitleId LONG,
	jobCategoryId LONG,
	subUnitId LONG,
	locationId LONG,
	employmentStatusId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	joinedDate DATE null,
	employmentContractStartDate DATE null,
	employmentContractEndDate DATE null,
	contractDetails BLOB
);

create table hrm_Nationality (
	nationalityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	Name VARCHAR(75) null
);

create table supervisor (
	supervisorId LONG not null primary key,
	employeeId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	reportingMethod LONG
);