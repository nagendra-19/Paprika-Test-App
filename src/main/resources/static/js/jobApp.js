import {JobAPI} from "./jobAPI.js";

export class JobApp {
	static async newOrUpdateJob(id){
	    var newJob = {};
	    if (id != null) {
	        newJob['JO_MN'] = Number(id);
	    }
        Array.from(document.querySelectorAll('[data-ref]'))
        				.forEach((element) => {
        					if (element.dataset.ref.match('JO_DATE') && element.value != '') {
        					    newJob[element.dataset.ref] = moment(new Date(element.value)).format('YYYY-MM-DDTHH:mm:ss.SSS[Z]');
        					} else if (element.dataset.ref == ('JO_SA_MN')
        					    || element.dataset.ref == ('JO_PROBABILITY')
        					    || element.dataset.ref.match('JO_NUMBER')
        					    || element.dataset.ref == ('JO_BU_MN'))  {
        					    newJob[element.dataset.ref] = Number(element.value);
        					} else if(!element.dataset.ref.match('JO_DATE')
        					    && element.dataset.ref != ('JO_SA_MN')
                                && element.dataset.ref != ('JO_PROBABILITY')
                                && !element.dataset.ref.match('JO_NUMBER')
                                && element.dataset.ref != ('JO_BU_MN')
                                && element.dataset.ref != ('JO_ACTIVE')) {
        					    newJob[element.dataset.ref] = element.value;
        					}
        				});
        JobAPI.putJob(newJob);
	}

	static async loadDefaults() {
	const systemCodesResp = await JobAPI.getSystemCodes();

    			// Build JO_SA_MN <select>
    			const joSaMnSelect = document.querySelector('[data-ref=JO_SA_MN]'),
    				saList = await JobAPI.getSaList();

    			saList.map((sa) => new Option(sa.SA_COMPANY_NAME, sa.SA_MN))
    				.forEach((option) => joSaMnSelect.add(option));


    			// Build JO_FEE_TYPE <select>
    			const joFeeTypeSelect = document.querySelector('[data-ref=JO_FEE_TYPE]'),
    			    feeList = systemCodesResp.FeeTypes;

    			feeList.map((fee) => new Option(fee.FEE_DESC, fee.FEE_CODE))
    				.forEach((option) => joFeeTypeSelect.add(option));


    			// Build JO_BU_MN <select>
    			const joBuMnSelect = document.querySelector('[data-ref=JO_BU_MN]'),
    				buList = systemCodesResp.BusinessUnits;

    			buList.map((bu) => new Option(bu.BU_DESC, bu.BU_MN))
    				.forEach((option) => joBuMnSelect.add(option));


    			// Build JO_BU_MN <select>
    			const joStatusSelect = document.querySelector('[data-ref=JO_STATUS]'),
    				stList = systemCodesResp.Statuses;

    			stList.map((st) => new Option(st.ST_DESC, st.ST_CODE))
    				.forEach((option) => joStatusSelect.add(option));
	}

	static async loadJob(id){
		try {
			// Fetch record from the 'JobAPI' that corresponds to the 'id' (from GET parameter).
            const job = await JobAPI.getJob(id);

            if (!job) {
                throw new Error('Record not found');
            }

            await this.loadDefaults();


			// Populate all form controls with values from 'job' object, based on the 'data-ref' attribute.
			Array.from(document.querySelectorAll('[data-ref]'))
				.filter((element) => (element.dataset.ref in job))
				.forEach((element) => {
				    if (element.dataset.ref.match('JO_DATE') && element.value != '' && element.value != undefined) {
                        element.value = moment(new Date(job[element.dataset.ref])).format('YYYY-MM-DDTHH:mm:ss');
				    } else {
					    element.value = job[element.dataset.ref];
				    }
				});
		} catch(e) {
			alert(e.message);
		}
	}

	static clearJob(){
	    if(!document.location.href.endsWith('index.html')){
            window.location.href = '/index.html'
	    }
    }
}