
//	Sample SA (Client) data
const saData = new Map([
	['5', {SA_MN: 5, SA_COMPANY_NAME: 'Theirworld'}],
	['24',{SA_MN: 24, SA_COMPANY_NAME: 'Saboteur'}]
]);

export class JobAPI {
	static async getSaList(){
		return Array.from(saData.values());
	}

	static async getSystemCodes(){
        let systemCodes = {};
		 await fetch('http://localhost:8080/getSystemCodes')
         .then(response=>response.json())
         .then(data=> {
            systemCodes = data?.result;
            });
        return systemCodes;
	}

	static async getJob(id){
        let job = {};
        await fetch('http://localhost:8080/getJob?JO_MN='+id)
        .then(response=>response.json())
        .then(data=>job = data?.result?.Job);
        return job;
	}

	static async putJob(jobJson){
	var res = {};
	await fetch('http://localhost:8080/saveOrUpdateJob', {
      method: "POST",
      body: JSON.stringify(jobJson),
      headers: {"Content-type": "application/json; charset=UTF-8"}
    })
    .then(response => response.json())
    .then(json => res = json)
    .catch(err => console.log(err));

    return res;
    }

	static async patchJob(id, jobJson){

	}

}