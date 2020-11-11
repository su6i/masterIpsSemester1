$(document).ready(function() {
    if ($("#tickers")) {

        // $("#tickers").select2({
            $(".js-example-basic-multiple").select2({
            multiple: true,
            ajax: {
                url: "/financelist",
                dataType: "json",
                delay: 250,
                data: function(a) {
                    var markets = [], serialization;
                    $(".markets input:checked").each(function (market) {
                        markets.push($(this).val())
                    })

                    markets = markets.join(",");
                    serialization = $(".serialization input:checked").val();

                    return {
                        q: a.term,
                        markets: markets,
                        serialization: serialization,
                        page: a.page
                    };
                },
                processResults: function(a, b) {
                    return {
                        results: a.items
                    };
                },
                cache: true
            },
            escapeMarkup: function(a) {
                return a;
            },
            minimumInputLength: 1,
            templateResult: a,
            templateSelection: b
        });
    }
    function a(a) {
        if (a.loading) return a.text;
        // var b = '<div class="avatar">' + '<img src="' + a.owner.avatar_url + '" style="max-width: 100%" />' + "</div>" + '<div class="info">' + '<div class="col-sm-6">' + a.full_name + "</div>" + '<div class="col-sm-3"><i class="fa fa-code-fork"></i> ' + a.forks_count + "</div>" + '<div class="col-sm-2"><i class="fa fa-star"></i> ' + a.stargazers_count;
        // if (a.description) b += "<div>" + a.description + "</div>";
        // b += "</div></div>";
        // var b = '<div class="col-sm-6">';
        // b += a.ticker + '</div>';
        var b = a.id;

        return b;
    }
    function b(a) {
        return a.id|| a.fullName;
    }

});