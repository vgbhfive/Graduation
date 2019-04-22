/**
 * @Auther: Vgbh
 * Home.html
 */

element = function (str) {
	return document.getElementById(str);
}

elementVal = function (str) {
	return document.getElementById(str).value;
}

elementSel = function (str) {
	return document.getElementById(str).selectedIndex;
}

//一周过期
function setCookie(name, value) {
    var exp = new Date();
    exp.setTime(exp.getTime() + 60 * 60 * 1000 * 24 * 7);
    document.cookie = name + "=" + value + ";expires=" + exp.toGMTString() + ";path=/";
}

//读取cookies
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

    if (arr = document.cookie.match(reg))

        return unescape(arr[2]);
    else
        return null;
}

//id: change_Money
changeMoney = function () {
	var index = elementSel("buy_Currency");
	var haveMoney = elementVal("have_Money");
	var index2 = elementSel("buy_Currency2");
	//console.log(index + "  " + haveMoney + "  " + index2);
	var currency = 0;
	var currency2 = 0;
	switch(index) {
		case 0:
			alert("请选择持有币种！");break;
		case 1:
			currency = haveMoney;break;
		case 2:
			currency = haveMoney * 6.71;break;
		case 3:
			currency = haveMoney * 8.84;break;
		case 4:
			currency = haveMoney * 7.59;break;
		case 5:
			currency = haveMoney * 0.061;break;
		case 6:
			currency = haveMoney * 0.85;break;
		case 7:
			currency = haveMoney * 6.67;break;
	}
	//console.log(currency);
	switch(index2) {
		case 0:
		alert("请选择兑换币种！"); break;
		case 1:
		currency2 = currency; break;
		case 2:
		currency2 = currency * 0.15; break;
		case 3:
		currency2 = currency * 0.11; break;
		case 4:
		currency2 = currency * 0.13; break;
		case 5:
		currency2 = currency * 16.41; break;
		case 6:
		currency2 = currency * 1.17; break;
		case 7:
		currency2 = currency * 0.15; break;
	}
	var haveMoney2 = element("have_Money2");
	haveMoney2.value = currency2;
}

//id: insurance_Change
insuranceChange = function () {
	var incomeType = elementSel("income_Type");
	var liveCity = elementSel("live_City");
	var peopleIncome = elementVal("people_Income");
	var medicalInsurance = elementVal("medical_Insurance");
	var loseworkInsurance = elementVal("losework_Insurance");
	var pensionInsurance = elementVal("pension_Insurance");
	var workbadInsurance = elementVal("workbad_Insurance");
	var babyInsurance = elementVal("baby_Insurance");
	var homeFund = elementVal("home_Fund");
	var specialDecution = elementVal("special_Decution");
	console.log(incomeType + "  " + liveCity + "  " + peopleIncome + "  " + medicalInsurance + "  " + loseworkInsurance + "  "
		 + pensionInsurance + "  " + workbadInsurance + "  " + babyInsurance + "  " + homeFund + "  " + specialDecution);
	var actual = 0;
	var actualIncome = element("actual_Income");
	if (liveCity == 0) {
		alert("请选择城市！");
	}
	if (incomeType == 0) {
		alert("请选择收入类型！");
	} else if (incomeType == 1) { //月薪
		peopleIncome2 = peopleIncome - specialDecution - 5000; //扣除专项和起薪
		actual = peopleIncome2 * ((parseInt(medicalInsurance) + parseInt(loseworkInsurance) + 
			parseInt(pensionInsurance) + parseInt(workbadInsurance) + parseInt(babyInsurance) + parseInt(homeFund)) / 100); //扣除五险一金
		peopleIncome3 = peopleIncome2 - actual;
		//console.log(peopleIncome3 + "  " + peopleIncome + "  " + actual);
		if (peopleIncome3 <= 3000) {
			actualIncome.value = (peopleIncome - (peopleIncome3 * 0.03) + actual);
		} else if (peopleIncome3 <= 12000) {
			actualIncome.value = peopleIncome - (peopleIncome3 * 0.1) - 210 - actual;
		} else if (peopleIncome3 <= 25000) {
			actualIncome.value = peopleIncome - (peopleIncome3 * 0.2) - 1410 - actual;
		} else if (peopleIncome3 <= 35000) {
			actualIncome.value = peopleIncome - (peopleIncome3 * 0.25) - 2660 - actual;
		} else if (peopleIncome3 <= 55000) {
			actualIncome.value = peopleIncome - (peopleIncome3 * 0.3) - 4410 - actual;
		} else if (peopleIncome3 <= 80000) {
			actualIncome.value = peopleIncome - (peopleIncome3 * 0.35) - 7160 - actual;
		} else {
			actualIncome.value = peopleIncome - (peopleIncome3 * 0.45) - 15160 - actual;
		}
	} else if (incomeType == 2) { //年终奖
		if (peopleIncome <= 36000) {
			actualIncome.value = peopleIncome - (peopleIncome * 0.03);
		} else if (peopleIncome <= 144000) {
			actualIncome.value = peopleIncome - (peopleIncome * 0.1) - 210;
		} else if (peopleIncome <= 300000) {
			actualIncome.value = peopleIncome - (peopleIncome * 0.2) - 1410;
		} else if (peopleIncome <= 420000) {
			actualIncome.value = peopleIncome - (peopleIncome * 0.25) - 2660;
		} else if (peopleIncome <= 660000) {
			actualIncome.value = peopleIncome - (peopleIncome * 0.3) - 4410;
		} else if (peopleIncome <= 960000) {
			actualIncome.value = peopleIncome - (peopleIncome * 0.35) - 7160;
		} else {
			actualIncome.value = peopleIncome - (peopleIncome * 0.45) - 15160;
		}
 	} else if (incomeType == 3) {//经营所得
 		if (peopleIncome < 30000) {
 			actualIncome.value = peopleIncome * 0.95;
 		} else if (peopleIncome < 90000) {
 			actualIncome.value = peopleIncome * 0.9;
 		} else if (peopleIncome < 300000) {
 			actualIncome.value = peopleIncome * 0.8;
 		} else if (peopleIncome < 500000) {
 			actualIncome.value = peopleIncome * 0.7;
 		} else {
 			actualIncome.value = peopleIncome * 0.65;
 		} 
 	}  else if (incomeType == 4) {//个体工商户
 		if (peopleIncome < 15000) {
 			actualIncome.value = peopleIncome * 0.95;
 		} else if (peopleIncome < 30000) {
 			actualIncome.value = peopleIncome * 0.9 - 750;
 		} else if (peopleIncome < 60000) {
 			actualIncome.value = peopleIncome * 0.8 - 3750;
 		} else if (peopleIncome < 100000) {
 			actualIncome.value = peopleIncome * 0.7 - 9750;
 		} else {
 			actualIncome.value = peopleIncome * 0.65 - 14750;
 		} 
 	} else if (incomeType == 5) {//劳务报酬
 		if (peopleIncome < 16000) {
 			actualIncome.value = peopleIncome * 0.8;
 		} else if (peopleIncome < 37000) {
 			actualIncome.value = peopleIncome * 0.7 - 2000;
 		}  else {
 			actualIncome.value = peopleIncome * 0.6 - 7000;
 		} 
 	}
}

liveCity = function () {
	var index = elementSel("live_City");
	var medicalInsurance = element("medical_Insurance");
	var loseworkInsurance = element("losework_Insurance");
	var pensionInsurance = element("pension_Insurance");
	var workbadInsurance = element("workbad_Insurance");
	var babyInsurance = element("baby_Insurance");
	var homeFund = element("home_Fund");
	//console.log(index + "  " + medicalInsurance.value + "  " + loseworkInsurance.value + "  " + pensionInsurance.value + "  " + workbadInsurance.value + "  " + babyInsurance.value + "  " + homeFund.value);
	switch (index) {
		case 1:
			// medicalInsurance.value = 2;
			// loseworkInsurance.value = 2;
			// pensionInsurance.value = 8;
			// workbadInsurance.value = 0;
			// babyInsurance.value = 0;
			// homeFund.value = 8;
			break;
		case 2:
			// medicalInsurance.value = 2;
			// loseworkInsurance.value = 2;
			// pensionInsurance.value = 8;
			// workbadInsurance.value = 0;
			// babyInsurance.value = 0;
			// homeFund.value = 8;
			break;
		case 3:
			// medicalInsurance.value = 2;
			// loseworkInsurance.value = 2;
			// pensionInsurance.value = 8;
			// workbadInsurance.value = 0;
			// babyInsurance.value = 0;
			// homeFund.value = 8;
			break;
		case 4:
			// medicalInsurance.value = 2;
			// loseworkInsurance.value = 2;
			// pensionInsurance.value = 8;
			// workbadInsurance.value = 0;
			// babyInsurance.value = 0;
			// homeFund.value = 8;
			break;
	}
}

incomeType = function () {
	var index = elementSel("income_Type");
	var medicalInsurance = element("medical_Insurance");
	var loseworkInsurance = element("losework_Insurance");
	var pensionInsurance = element("pension_Insurance");
	var workbadInsurance = element("workbad_Insurance");
	var babyInsurance = element("baby_Insurance");
	var homeFund = element("home_Fund");
	switch (index) {
		case 1:
			medicalInsurance.value = 2;
			loseworkInsurance.value = 2;
			pensionInsurance.value = 8;
			workbadInsurance.value = 0;
			babyInsurance.value = 0;
			homeFund.value = 8;
			break;
		case 2:
			medicalInsurance.value = 0;
			loseworkInsurance.value = 0;
			pensionInsurance.value = 0;
			workbadInsurance.value = 0;
			babyInsurance.value = 0;
			homeFund.value = 0;
			break;
		case 3:
			medicalInsurance.value = 0;
			loseworkInsurance.value = 0;
			pensionInsurance.value = 0;
			workbadInsurance.value = 0;
			babyInsurance.value = 0;
			homeFund.value = 0;
			break;
		case 4:
			medicalInsurance.value = 0;
			loseworkInsurance.value = 0;
			pensionInsurance.value = 0;
			workbadInsurance.value = 0;
			babyInsurance.value = 0;
			homeFund.value = 0;
			break;
		case 5:
			medicalInsurance.value = 0;
			loseworkInsurance.value = 0;
			pensionInsurance.value = 0;
			workbadInsurance.value = 0;
			babyInsurance.value = 0;
			homeFund.value = 0;
			break;
	}
}
 
//id: home_Fund_Change
homeFundChange = function () {
	var monthIncome = elementVal("month_Income_Three");
	var peoplePropor = elementVal("people_Propor");
	var companyPropor = elementVal("company_Propor");
	//console.log(monthIncome + "  " + peoplePropor + "  " + companyPropor);
	var monthOutcome = element("month_Outcome");
	var monthOutcomePeople = element("month_Outcome_People");
	var monthOutcomeCompany = element("month_Outcome_Company");
	monthOutcome.value = monthIncome * 0.2;
	monthOutcomePeople.value = monthIncome * 0.08;
	monthOutcomeCompany.value = monthIncome * 0.12;
}

//id: medical_Insurance_Change
medicalInsuranceChange = function () {
	var monthIncome = elementVal("month_Income_Four");
	var upIntrate = elementVal("up_Intrate");
	var peopleIntrate = elementVal("people_Intrate");
	var companyIntrate = elementVal("company_Intrate");
	var nowAge = elementVal("now_Age");
	var downAge = elementVal("down_Age");
	console.log(monthIncome + "  " + upIntrate + "  " + peopleIntrate + "  " + companyIntrate + " " + nowAge + "  " + downAge);
	var monthMedicalInsuranceOutcome = element("month_Medical_Insurance_Outcome");
	var monthMedicalInsuranceOutcomePeople = element("month_Medical_Insurance_Outcome_People");
	var monthMedicalInsuranceOutcomeCompany = element("month_Medical_Insurance_Outcome_Company");
	monthMedicalInsuranceOutcome.value = parseInt(monthIncome * 0.28);
	monthMedicalInsuranceOutcomePeople.value = monthIncome * 0.08;
	monthMedicalInsuranceOutcomeCompany.value = monthIncome * 0.2;
	var months = (downAge - nowAge) * 12;
	var allMedicalInsuranceOutcome = element("all_Medical_Insurance_Outcome");
	var all = 0;
	for (var i = 1; i <= months; i++) {
		all += monthIncome * 1.05 * 0.28;
		if (i % 12 == 0) {
			monthIncome *= 1.05;
		}
	}
	allMedicalInsuranceOutcome.value = parseInt(all);
}

//id: income_Money_Change
incomeMoneyChange = function () {
	var incomeMoney = elementVal("income_Money_Five");
	var incomeDate = elementSel("income_Date_Five");
	var incomeIntrate = elementVal("income_Intrate");
	console.log(incomeMoney + "  " + incomeDate + "  " + incomeIntrate);

	var intrateMoney = element("intrate_Money_Five");
	var intrateMoneyAndMoney = element("intrate_Money_And_Money_Five");
	switch (parseInt(incomeDate)) {
		case 0:
			alert("-请选择存储年限！-");break;
		case 1:
			intrateMoney.value = parseInt(incomeMoney) * parseFloat(incomeIntrate) * 4 / 100;
			intrateMoneyAndMoney.value = parseInt(incomeMoney) + parseInt(intrateMoney.value);break;
		case 2:
			intrateMoney.value = parseInt(incomeMoney) * parseFloat(incomeIntrate) * 8 / 100;
			intrateMoneyAndMoney.value = parseInt(incomeMoney) + parseInt(intrateMoney.value);break;
		case 3:
			intrateMoney.value = parseInt(incomeMoney) * parseFloat(incomeIntrate) * 12 / 100;
			intrateMoneyAndMoney.value = parseInt(incomeMoney) + parseInt(intrateMoney.value);break;
		case 4:
			intrateMoney.value = parseInt(incomeMoney) * parseFloat(incomeIntrate) * 20 / 100;
			intrateMoneyAndMoney.value = parseInt(incomeMoney) + parseInt(intrateMoney.value);break;
	}
}

//id: study_Income_Money_Change
studyIncomeMoneyChange = function () {
	var incomeMoney = elementVal("income_Money_Six");
	var incomeDate = elementSel("income_Date_Six");
	console.log(incomeMoney + "  " + incomeDate);

	var monthIntrateMoney = element("month_Intrate_Money_Six");
	var intrateMoney = element("intrate_Money_Six");
	var intrateMoneyAndMoney = element("intrate_Money_And_Money_Six");
	monthIntrateMoney.value = parseInt(incomeMoney) * 0.025;
	switch (parseInt(incomeDate)) {
		case 0:
			alert("-请选择存储年限！-");break;
		case 1:
			intrateMoney.value = parseInt(incomeMoney) * 0.025 * 12;
			intrateMoneyAndMoney.value = parseInt(incomeMoney) * 12 + parseInt(intrateMoney.value);break;
		case 2:
			intrateMoney.value = parseInt(incomeMoney) * 0.025 * 24;
			intrateMoneyAndMoney.value = parseInt(incomeMoney) * 12 + parseInt(intrateMoney.value);break;
		case 3:
			intrateMoney.value = parseInt(incomeMoney) * 0.025 * 36;
			intrateMoneyAndMoney.value = parseInt(incomeMoney) * 12 + parseInt(intrateMoney.value);break;
		case 4:
			intrateMoney.value = parseInt(incomeMoney) * 0.025 * 60;
			intrateMoneyAndMoney.value = parseInt(incomeMoney) * 12 + parseInt(intrateMoney.value);break;
	}
}

//id: loan_Money_Change
//TODO: Error
loanMoneyChange = function () {
	var loanMoney = elementVal("loan_Money");
	var returnDate = elementVal("return_Date");
	var intrate = elementVal("intrate_Seven");
	console.log(loanMoney + "  " + returnDate + "  " + intrate); 

	var monthReturn = element("month_Return");
	var intrateMoney = element("intrate_Money_Seven");
	var intrateMoneyAndMoney = element("intrate_Money_And_Money_Seven");

	var money = parseInt(loanMoney);
	var date = parseInt(returnDate) * 12;
	var monthMoney = money / date; //每月归还本金
	intrate = parseFloat(intrate);
	console.log(money + "  " + date + "  " + monthMoney + " " + intrate);

	var month = money * (intrate / 1200) * [(1 + intrate/1200) ^ date] / [(1 + intrate/1200) ^ date - 1]; //Error
	console.log(month);
	console.log("zi" + (money * (intrate / 1200) * [(1 + intrate/1200) ^ date]));
	console.log("mu" + ((1 + intrate/1200) ^ date - 1));

	//200000*（7.05%/12）*(1+7.05%/12)^180   /    [(1+7.05%/12)^180-1] =1803.251917
	//每月还款金额 (简称每月本息) =贷款本金 X	月利率×[（1+月利率）^ 还款月数÷[（1+月利率）^ 还款月数 ] - 1
}

//id: debt_Change
debtChange = function () {
	var buyMoney = elementVal("buy_Money");
	var buyDate = elementSel("buy_Date");
	var yearIntrate = elementVal("year_Intrate");
	console.log(buyMoney + "  " + buyDate + "  " + yearIntrate); 

	var intrateMoney = element("intrate_Money_Eight");
	var intrateMoneyAndMoney = element("intrate_Money_And_Money_Eight");
	var money = parseInt(buyMoney);
	var intrate = parseFloat(yearIntrate);
	var date = 0;
	switch (buyDate) {
		case 0:
			alert("请选择购买年限！");break;
		case 1:
			date = 1;
			intrateMoney.value = money * date * intrate / 100;break;
		case 2:
			date = 2;
			intrateMoney.value = money * date * intrate / 100;break;
		case 3:
			date = 3;
			intrateMoney.value = money * date * intrate / 100;break;
		case 4:
			date = 5;
			intrateMoney.value = money * date * intrate / 100;break;
	}
	intrateMoneyAndMoney.value = money + parseInt(intrateMoney.value);
}

function requestData(url, method, data, cb) {
    var xhr = new XMLHttpRequest();
    xhr.open(method || 'get', url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            var  result = xhr.response;
            try {
                result = JSON.parse(result)
            } catch (e) {
                console.warn('解析 JSON 失败', e);
            }
            cb && cb({
                status: xhr.status,
                data: result
            });
        }
    }
    if (typeof(data) === 'object') {
        data = JSON.stringify(data);
    }
    xhr.send(data);
}

//id: day_Input_Output
dayInputOutput = function () {
    var money = elementVal("use_Money");
    var income = elementVal("income");
    var use = elementSel("how_Use");
    // var datetimes = elementVal("datetimes");
    var contents = elementVal("other_Contents");
    switch (use) {
        case 0: use = "日常饮食"; break;
        case 1: use = "交通出行"; break;
        case 2: use = "服饰美容"; break;
        case 3: use = "住房缴费"; break;
        case 4: use = "文教健康"; break;
        default: break;
    }
    if (getCookie("token")) {
        requestData('/day/save', 'post', {
            "userId": getCookie("userId"),
            "money": money,
            "income": income == 1 ? true : false,
            "use": use,
            "content": contents
        }, function (res) {
            if (res.status === 200) {
                // console.log(JSON.parse(res.data));
                alert("添加成功！");
            } else {
                alert("Error:" + res.data);
            }
        });
    } else {
        alert("请您先登录！");
    }
}

//id: day_All
dayAll = function () {
	window.location.href = "http://localhost:8080/dayall";
}

//loadData
load = function () {
    requestData('/financial/all', 'get', {}, function (res) {
        // console.log(JSON.parse(res.data));
        var json = JSON.parse(res.data)["data"];
        if (res.status === 200) {
            var x = "";
            var dataView = document.getElementsByClassName("financialTable")[0];
            var table = document.createElement('table');
            table.classList.add("table");
            table.classList.add("table-striped");
            var thead = document.createElement('thead');
            thead.innerHTML = '<tr><th>FinancialId</th><th>Name</th><th>Money</th><th>Deadline</th><th>Intrate</th><th>ExpectReturn</th><th>Contents</th><th>购买</th></tr>';
            table.appendChild(thead);
            var tbody = document.createElement('tbody');
            for (var i = 0; i < json["length"]; i++) {
                (function (i) {
                    x += "<td>" + json[i]["id"] + "</td>";
                    x += "<td>" + json[i]["name"] + "</td>";
                    x += "<td>" + json[i]["money"] + "</td>";
                    x += "<td>" + json[i]["deadline"] + "</td>";
                    x += "<td>" + json[i]["intrates"] + "</td>";
                    x += "<td>" + json[i]["expectReturn"] + "</td>";
                    x += "<td>" + json[i]["contents"] + "</td>";
                    var row = document.createElement('tr');
                    row.innerHTML = x;
                    var op = document.createElement('button');
                    op.innerText = "购买";
                    op.setAttribute('style', 'height: 35px; width: 70px; padding-right: 10px; margin: 0 auto;');
                    op.addEventListener("click", function () { buyFinancial(json[i]); }, false);
                    row.appendChild(op);
                    tbody.appendChild(row);
                    x = "";
                }(i));
            }
            table.appendChild(tbody);
            dataView.appendChild(table);
        } else {
            alert('请求失败: ' + res.status);
        }
    });
    requestData('/loan/all', 'get', {}, function (res) {
        // console.log(JSON.parse(res.data));
        var json = JSON.parse(res.data)["data"];
        if (res.status === 200) {
            var x = "";
            var dataView = document.getElementsByClassName("loanTable")[0];
            var table = document.createElement('table');
            table.classList.add("table");
            table.classList.add("table-striped");
            var thead = document.createElement('thead');
            thead.innerHTML = '<tr><th>LoanId</th><th>Money</th><th>ReturnDate</th><th>Type</th><th>Intrate</th><th>Odds</th><th>Contents</th><th>购买</th></tr>';
            table.appendChild(thead);
            var tbody = document.createElement('tbody');
            for (var i = 0; i < json["length"]; i++) {
                (function (i) {
                    x += "<td>" + json[i]["loanId"] + "</td>";
                    x += "<td>" + json[i]["money"] + "</td>";
                    x += "<td>" + json[i]["returnDate"] + "</td>";
                    x += "<td>" + json[i]["type"] + "</td>";
                    x += "<td>" + json[i]["intrate"] + "</td>";
                    x += "<td>" + json[i]["odds"] + "</td>";
                    x += "<td>" + json[i]["contents"] + "</td>";
                    var row = document.createElement('tr');
                    row.innerHTML = x;
                    var op = document.createElement('button');
                    op.innerText = "购买";
                    op.setAttribute('style', 'height: 35px; width: 70px; padding-right: 10px; margin: 0 auto;');
                    op.addEventListener('click', function () { buyLoan(json[i]); }, false);
                    row.appendChild(op);
                    tbody.appendChild(row);
                    x = "";
                }(i));
            }
            table.appendChild(tbody);
            // console.log(dataView);
            dataView.appendChild(table);
        } else {
            alert('请求失败: ' + res.status);
        }
    });
    loadPersonAssets();
}

loadPersonAssets = function () {
    var assets = document.getElementById("assetsTable");
    var assetserror = document.getElementById("assetsError");
    if (getCookie("token")) {
        assets.style.display = "inline";
        assetserror.style.display = "none";
        requestData("/assets/all/"+getCookie("userId"), 'get', {}, function (res) {
            var json = JSON.parse(res.data)["data"];
            // console.log(json);
            var x = "";
            var dataView = document.getElementsByClassName("assetsTable")[0];
            var table = document.createElement('table');
            table.classList.add("table");
            table.classList.add("table-striped");
            var thead = document.createElement('tr');
            thead.innerHTML = '<tr><th>Id</th><th>Money</th><th>Datatimes</th><th>Cycle</th><th>Property</th><th>Source</th><th>Contents</th></tr>';
            table.appendChild(thead);
            var tbody = document.createElement('tbody');
            if (json["length"] == null) return;
            for (var i = 0; i < json["length"]; i++) {
                // console.log(json[i]);
                x += "<td>" + json[i]['id'] + "</td>";
                x += "<td>" + json[i]["money"] + "</td>";
                x += "<td>" + json[i]["datetimes"] + "</td>";
                x += "<td>" + json[i]["cycle"] + "</td>";
                x += "<td>" + json[i]["property"] + "</td>";
                x += "<td>" + json[i]["source"] + "</td>";
                x += "<td>" + json[i]["contents"] + "</td>";
                var row = document.createElement('tr');
                row.innerHTML = x;
                tbody.appendChild(row);
                x = "";
            }
            table.appendChild(tbody);
            dataView.appendChild(table);
        })
    } else {
        assets.style.display = "none";
        assetserror.style.display = "inline";
    }
}

function buyFinancial(data) {
    requestData('/assets/save', 'post', {
        "userId" : getCookie("userId"),
        "money" : data["money"],
        "cycle" : data["deadline"],
        "property" : data["name"],
        "source" : "理财",
        "content" : data["contents"]
    }, function (res) {
        if (res.status === 200) {
            // console.log(JSON.parse(res.data));
            // loadPersonAssets();
            alert("购买成功!");
        } else {
            alert("Error:" + res.data);
        }
    });
}

function buyLoan(data) {
    requestData('/assets/save', 'post', {
        "userId" : getCookie("userId"),
        "money" : data["money"],
        "cycle" : data["returnDate"],
        "property" : data["type"],
        "source" : "贷款",
        "content" : data["contents"]
    }, function (res) {
        if (res.status === 200) {
            // console.log(JSON.parse(res.data));
            // loadPersonAssets();
            alert("购买成功!");
        } else {
            alert("Error:" + res.data);
        }
    });
}

