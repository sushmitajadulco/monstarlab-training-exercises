var message;
var calc_panel;
var curr_button;

$( document ).ready(function() {
    console.log( "ready!" );
    curr_button = 0;
    inMenu = true;
    $('.contact-button').attr({
        'style': 'background-color:#f1c675'
    });
    console.log(curr_button)

});

// -------------------------- Menu  ------------------------------

$('.contact-button').on({
    mousedown: function () {
        $('.menu-view').hide();
        $('.contacts-view').show();
    },
    mouseenter: function () {
        $('.contact-button').attr({
            'style': 'background-color:#f1c675' 
        });
        $('#bea').attr({
            'style': 'background-color:#f1c675'
        });
        $('#christian').attr({
            'style': 'background-color:none'
        });
        $('#perf').attr({
            'style': 'background-color:none'
        });
        curr_button=0;
    },
    mouseleave: function () {
        $('.contact-button').attr({
            'style': 'background-color:none'
        });
    }
});

$('.message-button').on({
    mousedown: function () {
        $('.menu-view').hide();
        $('.message-view').show();
    },
    mouseenter: function () {
        $('.message-button').attr({
            'style': 'background-color:#f1c675'
        });
    },
    mouseleave: function () {
        $('.message-button').attr({
            'style': 'background-color:none'
        });
    }
});
$('.calculator-button').on({
    mousedown: function () {
        $('.menu-view').hide();
        $('.calculator-view').show();
    },
    mouseenter: function () {
        $('.calculator-button').attr({
            'style': 'background-color:#f1c675'
        });
    },
    mouseleave: function () {
        $('.calculator-button').attr({
            'style': 'background-color:none'
        });
    }
});

// ------------------- Navigation -------------------------------

$('.back-button').on({
    mousedown: function () {
        $('.menu-view').show();
        $('.contacts-view').hide();
        $('.message-view').hide();
        $('.calculator-view').hide();
        curr_button = 0;
    }
});

$('.down-button').on({
    mousedown: function () {
        if (curr_button == 0) {
            $('.contact-button').attr({
                'style': 'background-color:none'
            });
            $('.calculator-button').attr({
                'style': 'background-color:#f1c675'
            });
            // for inside contacts
            $('#bea').attr({
                'style': 'background-color:none'
            });
            $('#christian').attr({
                'style': 'background-color:#f1c675'
            });
            curr_button++;
            console.log(curr_button);
        } else if (curr_button == 1) {
            $('.message-button').attr({
                'style': 'background-color:#f1c675'
            });
            $('.calculator-button').attr({
                'style': 'background-color:none'
            });
            // for inside contacts
            $('#christian').attr({
                'style': 'background-color:none'
            });
            $('#perf').attr({
                'style': 'background-color:#f1c675'
            });
            curr_button++;
            console.log(curr_button);
        } else {
            $('.message-button').attr({
                'style': 'background-color:none'
            });
            $('.contact-button').attr({
                'style': 'background-color:#f1c675'
            });
            // for inside contacts
            $('#perf').attr({
                'style': 'background-color:none'
            });
            $('#bea').attr({
                'style': 'background-color:#f1c675'
            });
            curr_button = 0;
            console.log(curr_button);
        }
    }
})
$('.up-button').on({
    mousedown: function () {
        if (curr_button == 0) {
            $('.message-button').attr({
                'style': 'background-color:#f1c675'
            });
            $('.contact-button').attr({
                'style': 'background-color:none'
            });
            // for inside contacts
            $('#bea').attr({
                'style': 'background-color:none'
            });
            $('#perf').attr({
                'style': 'background-color:#f1c675'
            });
            curr_button = 2;
            console.log(curr_button);
        } else if (curr_button == 1) {
            $('.contact-button').attr({
                'style': 'background-color:#f1c675'
            });
            $('.calculator-button').attr({
                'style': 'background-color:none'
            });
            // for inside contacts
            $('#christian').attr({
                'style': 'background-color:none'
            });
            $('#bea').attr({
                'style': 'background-color:#f1c675'
            });
            curr_button--;
            console.log(curr_button);
        } else {
            $('.calculator-button').attr({
                'style': 'background-color:#f1c675'
            });
            $('.message-button').attr({
                'style': 'background-color:none'
            });
            // for inside contacts
            $('#perf').attr({
                'style': 'background-color:none'
            });
            $('#christian').attr({
                'style': 'background-color:#f1c675'
            });
            curr_button--;
            console.log(curr_button);
        }
    }
});
$('.enter-button').on({
    mousedown: function () {
        if (curr_button == 0) {
            $('.menu-view').hide();
            $('.contacts-view').show();
        } else if (curr_button == 1) {
            $('.menu-view').hide();
            $('.calculator-view').show();
        } else {
            $('.menu-view').hide();
            $('.message-view').show();
        }
    }
});

// ---------------- Calculator -----------------------

function calC(c) {
    calc_panel = $('form #calc-panel').val() + c;
    $('form #calc-panel').val(calc_panel);
}

function Delete() {
    calc_panel = calc_panel.substring(0, calc_panel.length - 1)
    $('form #calc-panel').val(calc_panel);
}

function CE() {
    $('form #calc-panel').val('');
}

function calculate(result) {
    try{
        $('form #calc-panel').val(eval(result));
    } catch(e){};
}


// -------------    Messages   --------------------

$('.change-to-symbols').on({
    mousedown: function () {
        $('.lowercase-letters').hide();
        $('.uppercase-letters').hide();
        $('.numbers-symbols').show();
    }
});
$('.change-to-letters').on({
    mousedown: function () {
        $('.numbers-symbols').hide();
        $('.uppercase-letters').hide();
        $('.lowercase-letters').show();
    }
});

function key(c) {
    message = $('#message-panel').val() + c;
    $('#message-panel').val(message);
}

$('#toUppercase').on({
    mousedown: function () {
        $('.uppercase-letters').show();
        $('.lowercase-letters').hide();
        $('.numbers-symbols').hide();
    }
});
$('#toLowercase').on({
    mousedown: function () {
        $('.uppercase-letters').hide();
        $('.numbers-symbols').hide();
        $('.lowercase-letters').show();
    }
});