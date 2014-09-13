/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rknowsys.eapp.hrm.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the contractDetails column in Job.
 *
 * @author rknowsys
 * @see Job
 * @generated
 */
public class JobContractDetailsBlobModel {
	public JobContractDetailsBlobModel() {
	}

	public JobContractDetailsBlobModel(long jobId) {
		_jobId = jobId;
	}

	public JobContractDetailsBlobModel(long jobId, Blob contractDetailsBlob) {
		_jobId = jobId;
		_contractDetailsBlob = contractDetailsBlob;
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	public Blob getContractDetailsBlob() {
		return _contractDetailsBlob;
	}

	public void setContractDetailsBlob(Blob contractDetailsBlob) {
		_contractDetailsBlob = contractDetailsBlob;
	}

	private long _jobId;
	private Blob _contractDetailsBlob;
}