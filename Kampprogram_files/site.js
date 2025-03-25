// Please see documentation at https://learn.microsoft.com/aspnet/core/client-side/bundling-and-minification
// for details on configuring this project to bundle and minify static web assets.

function ShowAverageResults(e) {
    var player = $(e).data("player");
    var index = $(e).data("index");

    if ($(e).closest("tbody").find(".result[data-player=" + player + "]").length > 0) {
        $(e).closest("tbody").find(".result[data-player=" + player + "]").toggleClass("hide");
    }
    else {
        var url = "/AverageIndex?handler=Results&playerId=" + player + "&index=" + index + "&sport=" + $("#SportsType").val();

        if ($("#DistrictId").val() != "")
            url += "&DistrictId=" + $("#DistrictId").val();

        $.get(url, function (data) {
            $(e).closest("tr").after(data);
        });
    }
}

function searchAverageList(e) {
    var value = $(e).val().toLowerCase();
        
    $("#tblavgplayer tbody tr").filter(function () {       
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });    
}

function ShowScoreListResult(e) {
    var player = $(e).data("player");
    var row = $(e).data("row");
    var index = $(e).data("index");

    if ($(e).closest("tbody").find(".toplistitem[data-player=" + player + "]").length > 0) {
        $(e).closest("tbody").find(".toplistitem[data-player=" + player + "]").toggleClass("hide");
    }
    else {
        var url = "/TopList?handler=Results&playerId=" + player + "&rowId=" + row + "&index=" + index;
               
        $.get(url, function (data) {
            $(e).closest("tr").after(data);
        });
    }
}

function ShowMatchProgramResult(e) {
    var match = $(e).data("match");  
    var hometeam = $(e).data("hometeam"); 
    var sportstype = $("#sportstype").val();  
    var index = $(e).data("index");

    if ($(e).closest("tbody").find(".game[data-match=" + match + "]").length > 0) {
        $(e).closest("tbody").find(".game[data-match=" + match + "]").toggleClass("hide");
    }
    else {
        var url = "/MatchProgram?handler=Results&matchId=" + match + "&hometeamId=" + hometeam + "&index=" + index + "&sportstypeId=" + sportstype;

        $.get(url, function (data) {
            $(e).closest("tr").after(data);
        });
    }
}

function ShowPoolScoreResults(e) {

    if ($(e).data("teampoolrow")) {
        var teampoolrow = $(e).data("teampoolrow");
        var pool = $(e).data("pool");
        var index = $(e).data("index");
        var sportstype = $("#sportstype").val(); 

        if ($(e).closest("tbody").find(".result[data-teampoolrow=" + teampoolrow + "]").length > 0) {
            $(e).closest("tbody").find(".result[data-teampoolrow=" + teampoolrow + "]").toggleClass("hide");
        }
        else {
            var url = "/PoolScore?handler=TeamResults&teampoolrowId=" + teampoolrow + "&poolId=" + pool + "&index=" + index + "&sportstypeId=" + sportstype;

            $.get(url, function (data) {
                $(e).closest("tr").after(data);
            });
        }
    }    
    else if ($(e).data("player")) {
        var player = $(e).data("player");
        var pool = $(e).data("pool");
        var index = $(e).data("index");

        if ($(e).closest("tbody").find(".result[data-player=" + player + "]").length > 0) {
            $(e).closest("tbody").find(".result[data-player=" + player + "]").toggleClass("hide");
        }
        else {
            var url = "/PoolScore?handler=PlayerResults&playerId=" + player + "&poolId=" + pool + "&index=" + index;

            $.get(url, function (data) {
                $(e).closest("tr").after(data);
            });
        }
    }     
}

function ShowShootingTeamResults(e) {
    var shootingteam = $(e).data("shootingteam");

    if ($(e).closest("tbody").find(".clubresult[data-shootingteam=" + shootingteam + "]").length > 0) {
        $(e).closest("tbody").find(".clubresult[data-shootingteam=" + shootingteam + "]").toggleClass("hide");
    }    
}

function searchTabBar(e) {
    var value = $(e).val().toLowerCase();

    $("#tblmatchprogram tbody tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });

    $("#tblscorelist tbody tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });  

    if ($(".result-row").length > 0 || ($(".clubresult-row").length > 0)) {
        $(".table-striped tbody tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });   
    } 
}

function searchTabBarSelect(e) {
    var value = $(e).val().toLowerCase();      
          
    $("#tblmatchprogram tbody tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });   
        
    $("#tblscorelist tbody tr").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });  

    if ($(".result-row").length > 0) {
        if ($(e).val() == "") {
            $(".result-row").toggle(true);
        }
        else {
            $(".result-row").filter(function () {
                $(this).toggle($(this).data("rowname").toLowerCase().indexOf(value) > -1)
            });
        }             
    }

    if ($(".clubresult-row").length > 0) {
        if ($(e).val() == "") {
            $(".clubresult-row").toggle(true);
        }
        else {
            $(".clubresult-row").filter(function () {
                $(this).toggle($(this).data("rowname").toLowerCase().indexOf(value) > -1)
            });
        }                
    }   
}