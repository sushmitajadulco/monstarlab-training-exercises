//---------------------------------------------------------------------
// Answer #1
//---------------------------------------------------------------------

// Create a script to retrieve all the jobs that will display the code, title, and the total salary. Total
// salary is equal to the sum of the monthly salary and the overtime rate

db.job.find().forEach( function (job) {
    print("\ncode: " + job._id)
    print("title: " + job.title)
    print("total salary: " + job.monthly + job.overtime )
}).pretty()





//---------------------------------------------------------------------
// Answer #3
//---------------------------------------------------------------------

// Create a script to retrieve all employees displaying the ID number, job description and monthly
// salary. Only those employees that are not developers should be on the list. Developers are
// those Codesters, Codesmiths and Codemasters

db.employee.aggregate([
    { "$match": { job: { $nin: ["Codester", "Codesmith", "Codemaster"]} }},  
	{ "$lookup" : {
        "localField" : "job",
        "from" : "job",
        "foreignField": "title",
        "as": "job2"
	}},
	{ "$lookup" : {
		"localField" : "job",
		"from" : "job",
		"foreignField": "_id",
		"as": "job"
	}},
	{
		$project : {
			"_id" : 1,
			"first_name" : 1,
			"description" : { $cond : { if : { $eq : ["$job.description", []] }, then : "$job2.description", else: "$job.description" }},
			"salary" : { $cond : { if : { $eq : ["$job.monthly", []] }, then : "$job2.monthly", else: "$job.monthly" }}
		}
	}
]).pretty()


//---------------------------------------------------------------------
// Answer #4
//---------------------------------------------------------------------

// Create a script to retrieve all the active projects displaying the code, client and the date the
// project started. A project is active if there's no end date. In addition, display the last name of
// the project leader if there is one. Active projects must be displayed even if there is no project
// leader.

db.project.find().forEach( function( proj) {
        if( proj.end_date == null ) {
            print("\nCode: " + proj._id);
			print("Client: " + proj.client);
			print("Start date: " + proj.start_date);
            var name = proj.project_leader.split(' ');
            print("Project Leader: " + name[1]);
        }
    }
).pretty()





//---------------------------------------------------------------------
// Answer #5
//---------------------------------------------------------------------

// Display all employees with the project they handle. When employees are assigned to multiple
// projects, all their projects must also be on the list. In addition, display all employees even if
// there are no projects assigned to them. The list will display the employee's first name and last
// name, employee's job title and the code of the project they handle.


db.project_assignment.insertMany([
	{
		"project" : "RELOASSIST",
		"members" : "JC",
		"start_date" : new Date("2010/01/01")
	},
	{
		"project" : "RELOASSIST",
		"members" : "Mary",
		"start_date" : new Date("2009/10/10")
	},
	{
		"project" : "RELOASSIST",
		"members" : "Rogel Paulo",
		"start_date" : new Date("2010/04/26")
	},
	{
		"project" : "RELOASSIST",
		"members" : "Mohammad Omair",
		"start_date" : new Date("2010/10/01")
	},
	{
		"project" : "RELOASSIST",
		"members" : "Arjay",
		"start_date" : new Date("2011/04/01")
	},
	{
		"project" : "CMIS",
		"members" : "Cielo",
		"start_date" : new Date("2010/01/01")
	},
	{
		"project" : "CMIS",
		"members" : "Ellaine",
		"start_date" : new Date("2010/03/03")
	},
	{
		"project" : "CMIS",
		"members" : "Jhoanna",
		"start_date" : new Date("2010/05/10"),
		"end_date" : new Date("2012/07/10")
	},
	{
		"project" : "CMIS",
		"members" : "Kervi",
		"start_date" : new Date("2010/03/05")
	},
	{
		"project" : "CMIS_CTA",
		"members" : "Mohammad Omair",
		"start_date" : new Date("2010/06/01"),
		"end_date" : new Date("09/30/10")
	},
	{
		"project" : "CMIS_CTA",
		"members" : "Richard",
		"start_date" : new Date("2011/02/20")
	},
	{
		"project" : "CMIS_CTA",
		"members" : "JC",
		"start_date" : new Date("2010/05/05"),
		"end_date" : new Date("07/07/10")
	},
	{
		"project" : "CMIS_CTA",
		"members" : "Jhoanna",
		"start_date" : new Date("2010/05/05"),
		"end_date" : new Date("07/07/10")
	},
	{
		"project" : "CMIS_CTA",
		"members" : "Kervi",
		"start_date" : new Date("2010/04/05"),
		"end_date" : new Date("07/07/10")
	},
	{
		"project" : "CMIS_CTA",
		"members" : "Kervi",
		"start_date" : new Date("2010/04/05"),
		"end_date" : new Date("07/07/10")
	},
])

db.employee.aggregate([
    { "$lookup" : {
        "localField" : "first_name",
        "from" : "project_assignment",
        "foreignField": "members",
        "as": "project"
    }},
]).pretty()




//---------------------------------------------------------------------
// Answer #6
//---------------------------------------------------------------------

// Display all projects displaying the project code and the number of members in the project. Limit
// the list to the projects with more than three members.

db.project.aggregate( [
    { $match : { "members.3" : { $exists : true }}},
    {
        $project : {
            _id : 1,
            numberOfMembers : { $cond: { if: { $isArray: "$members" }, then: { $size: "$members" }, else: "NA"} }
        }
    }
]).pretty()




//---------------------------------------------------------------------
 // Answer #7
//---------------------------------------------------------------------

// Display all employees who also supervise other employees. This will display the full name of the
// employees and the number of employees they supervise.

 db.employee.aggregate( [
    {
        $group : {
            _id : { supervisor: "$supervisor"},
            count: {$sum: 1}
        }, 

    }
]).pretty()


//---------------------------------------------------------------------
// Answer #8
//---------------------------------------------------------------------

// Display all the project leaders with their job description and salary. This will display the full name
// of the project leader.

 db.project.aggregate([
        {
            $group : {
                _id : "$project_leader", 
                projects: { $push : { name: "$_id"}}
            }
        }
    ]
).forEach( function ( proj ) {

        db.employee.find(
            { $expr : { $eq : [ proj._id, { $concat : [ "$first_name", " " , "$last_name"  ] } ]  } }
        ).forEach(
            function (employee) {
                print(employee.first_name + " " + employee.last_name)
                db.job.find(
                    { $or : [ {title: employee.job}, {_id: employee.job} ]  }
                ).forEach (
                    function (job) {
                        print( job.description )
                        print( job.monthly )
                    }
                )
            }
        )
    }
)





