import { Component, OnInit } from '@angular/core';
import Map from 'ol/Map';
import View from 'ol/View';
import Tile from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import Attribution from 'ol/source/Source';
import { defaults } from 'ol/control/defaults'
import { fromLonLat } from 'ol/proj';
import Vector from 'ol/source/Vector';
import VectorLayer  from 'ol/layer/Vector';
import GeoJSON from 'ol/format/GeoJSON';
import Style from 'ol/style/Style';
import Icon from 'ol/style/Icon';


@Component({
  selector: 'mappa',
  templateUrl: './mappa.component.html',
  styleUrls: ['./mappa.component.css'],
})
export class MappaComponent implements OnInit {
  tuto:any;

  ngOnInit(): void {
    const key = 'TMygzTI9MV2J274M9Ln3';

      const attribution = new Attribution({
       
      });      

      const map = new Map({
        layers: [
          new Tile({
            source: new OSM({
            })
          })
        ],
        controls: defaults({attribution: false}),
        target: 'map',
        view: new View({
          constrainResolution: true,
          center: fromLonLat([16.62662018, 49.2125578]), // starting position [lng, lat]
          zoom: 5 // starting zoom
        })
      });

      const VectorSource=new Vector({
        url:'https://api.maptiler.com/data/8fec0037-4d1f-4f81-b0fc-e9bdf0a3ba12/features.json?key=TMygzTI9MV2J274M9Ln3',
        format:new GeoJSON(),
      })
      const AirportLayer = new VectorLayer({
        source:VectorSource,
        style:new Style({
          image: new Icon({
              src: 'https://docs.maptiler.com/openlayers/geojson-points/icon-plane-512.png',
              size: [512, 512],
              scale: 0.03
          })
        }) 
      })
      map.addLayer(AirportLayer);
  }

  clickSegnalazioni(){
    console.log("stai andando alle segnalazioni")
  }

  clickReward(){
    console.log("stai andando alle reward")
  }
}