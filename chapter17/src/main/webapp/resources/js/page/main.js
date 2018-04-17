/**
 * Created by Administrator on 2017/4/28.
 */
//地图配置开始
var styles = {
    'route': new ol.style.Style({
        stroke: new ol.style.Stroke({
            width: 6, color: [237, 212, 0, 0.8]
        })
    }),
    'icon': new ol.style.Style({
        image: new ol.style.Icon({
            anchor: [0.5, 1],
            src: 'https://openlayers.org/en/v4.1.0/examples/data/icon.png'
        })
    }),
    'geoMarker': new ol.style.Style({
        image: new ol.style.Circle({
            radius: 7,
            snapToPixel: false,
            fill: new ol.style.Fill({color: 'black'}),
            stroke: new ol.style.Stroke({
                color: 'white', width: 2
            })
        })
    })
};
var pointList = [
    ol.proj.fromLonLat([116, 40]),
    ol.proj.fromLonLat([115, 40]),
    ol.proj.fromLonLat([114, 40]),
    ol.proj.fromLonLat([113, 39]),
    ol.proj.fromLonLat([112, 38]),
    ol.proj.fromLonLat([111, 39]),
    ol.proj.fromLonLat([110, 41])
];
var lineString = new ol.geom.LineString(pointList, 'XY');
var routeLength = pointList.length;
//线
var routeFeature = new ol.Feature({
    type: 'route',
    geometry: lineString
});
//移动点
var geoMarker = new ol.Feature({
    type: 'geoMarker',
    geometry: new ol.geom.Point(pointList[0])
});
//起始图标
var startMarker = new ol.Feature({
    type: 'icon',
    geometry: new ol.geom.Point(pointList[0])
});
//结束图标
var endMarker = new ol.Feature({
    type: 'icon',
    geometry: new ol.geom.Point(pointList[routeLength - 1])
});
var routeVectorLayer = new ol.layer.Vector({
    source: new ol.source.Vector({
        features: [routeFeature, geoMarker, startMarker, endMarker]
    }),
    style: function (feature) {
        return styles[feature.get('type')];
    }
});

//中心点
var center = ol.proj.fromLonLat([116, 39]);
var map = new ol.Map({
    target: document.getElementById('map'),
    layers: [
        new ol.layer.Tile({
            source: new ol.source.OSM()
        }),
        routeVectorLayer
    ],
    controls: ol.control.defaults({
        attributionOptions: ({
            collapsible: false
        })
    }),
    view: new ol.View({
        center: center,
        zoom: 5,
        minZoom: 2,
        maxZoom: 9
    })
});
var animating = false;
var speed, now;
var replayTrackBtn = document.getElementById('replayTrackBtn');
//移动函数
var moveFeature = function (event) {
    var vectorContext = event.vectorContext;
    var frameState = event.frameState;

    if (animating) {
        var elapsedTime = frameState.time - now;
        // here the trick to increase speed is to jump some indexes
        // on lineString coordinates
        var index = Math.round(speed * elapsedTime / 1000);

        if (index >= routeLength) {
            stopAnimation(true);
            return;
        }

        var currentPoint = new ol.geom.Point(pointList[index]);
        var feature = new ol.Feature(currentPoint);
        vectorContext.drawFeature(feature, styles.geoMarker);
    }
    // tell OpenLayers to continue the postcompose animation
    map.render();
};
//开始移动
function startAnimation() {
    if (animating) {
        stopAnimation(false);
    } else {
        animating = true;
        now = new Date().getTime();
        speed = 3;
        replayTrackBtn.textContent = '取消回放';
        // hide geoMarker
        geoMarker.setStyle(null);
        // just in case you pan somewhere else
        map.getView().setCenter(center);
        map.on('postcompose', moveFeature);
        map.render();
    }
}
/**
 * @param {boolean} ended end of animation.
 */
function stopAnimation(ended) {
    animating = false;
    replayTrackBtn.textContent = '回放';

    // if animation cancelled set the marker at the beginning
    var coord = ended ? pointList[routeLength - 1] : pointList[0];
    /** @type {ol.geom.Point} */ (geoMarker.getGeometry())
        .setCoordinates(coord);
    //remove listener
    map.un('postcompose', moveFeature);
}

replayTrackBtn.addEventListener('click', function () {
    console.log(456);
    startAnimation();
},false);


//地图配置结束


//窗口的配置开始
function dealModal(data, targetURL) {
    $('#operationModalTitle').html($(data).text());
    $('#operationModal').modal();
    setTimeout(function () {
        $('#operationModalIframe').attr('src', basePath + '/v1/g/?target=' + targetURL);
    }, 300)

}

//窗口的配置结束