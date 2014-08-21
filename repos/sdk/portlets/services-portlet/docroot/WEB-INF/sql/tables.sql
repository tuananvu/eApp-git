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