<!DOCTYPE html>
<html>

<head>
    <?php include('head.php');?>
</head>

<body>
<?php /*include('side-nav.php'); */?> 

<!-- Main content -->
<div class="main-content" id="panel">
    <?php /*include('top-nav.php'); */?>
    <?php /*include('header.php');*/?>

    <div class="row" style="padding:15px">
        <div class="col-xl-4" >

            <div class="card card-stats">
                <div class="card-header">
                    <div class="row">
                        <div class="col-xl-1"></div>
                        <div class="col-xl-10">
                            <span class="badge badge-info"><h1>Input Parameters Control</h1></span>
                        </div>
                        <div class="col-xl-1"></div>
                    </div>
                </div>

                <div class="card-body">
                
                    <div class="row" style="margin-top:20px">
                        <div class="col-xl-3" style="">
                            <span class="badge badge-success"><h4>Voltage </h4></span>
                        </div>
                        <div class="col-xl-6" style="">
                            <input id="voltage-slider" type="text" data-slider-min="0" data-slider-max="100" data-slider-step="1" data-slider-value="0"/>
                        </div>
                        <div class="col-xl-3" style="">
                            <span id="voltage-slider-value-label">Value: <span id="voltage-slider-value">0</span></span>
                        </div>
                    </div>

                    <div class="row" style="margin-top:15px">
                        <div class="col-xl-3" style="">
                            <span class="badge badge-success"><h4>&nbsp;&nbsp;&nbsp;Load &nbsp;&nbsp;&nbsp;</h4></span>
                        </div>
                        <div class="col-xl-6" style="">
                            <input id="load-slider" type="text" data-slider-min="0" data-slider-max="100" data-slider-step="1" data-slider-value="0"/>
                        </div>
                        <div class="col-xl-3" style="">
                            <span id="load-slider-value-label">Value: <span id="load-slider-value">0</span></span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card card-stats">
                <div class="card-header">
                    <div class="row">
                        <div class="col-xl-1"></div>
                        <div class="col-xl-9">
                            <span class="badge badge-info"><h1>Output Parameters Display</h1></span>
                        </div>
                        <div class="col-xl-2"></div>
                    </div>
                </div>

                <div class="card-body">
                
                    <div class="row" style="margin-top:20px">
                        <div class="col-xl-4" style="">
                            <span class="badge badge-success"><h4>Temperature </h4></span>
                        </div>
                        <div class="col-xl-8" style="">
                            <div class="input-group">
                                <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
                            </div>
                        </div>
                    </div>

                    <div class="row" style="margin-top:15px">
                        <div class="col-xl-4" style="">
                            <span class="badge badge-success"><h4>&nbsp;&nbsp;&nbsp;&nbsp;Current&nbsp;&nbsp;&nbsp;&nbsp;</h4></span>
                        </div>
                        <div class="col-xl-8" style="">
                            <div class="input-group">
                                <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="col-xl-4" style="">
            <?php include('live-div.php'); ?>
        </div>

        <div class="col-xl-4" style="">
            <?php include('graphs-div.php'); ?>
        </div>

    </div>
</div>

<?php include('includes.php');?>
<script>

    var slider = new Slider("#voltage-slider");
    slider.on("slide", function(sliderValue) 
    {
	    document.getElementById("voltage-slider-value").textContent = sliderValue;
    });

    var slider = new Slider("#load-slider");
    slider.on("slide", function(sliderValue) 
    {
	    document.getElementById("load-slider-value").textContent = sliderValue;
    });

</script>

</body>

</html>