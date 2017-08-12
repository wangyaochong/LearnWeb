
// console.log("type of NODE_ENV ",typeof process.env.NODE_ENV);
// console.log("PRODUCTION",PRODUCTION);
// console.log("DEVELOPMENT",DEVELOPMENT);
// console.log("entry",entry);
// console.log("NODE_ENV",process.env.NODE_ENV,process.env.NODE_ENV=="production");
var path=require('path');
var webpack=require("webpack");
var ExtractTextPlugin=require("extract-text-webpack-plugin");
var htmlWebpackPlugin=require("html-webpack-plugin");
var DEVELOPMENT=(process.env.NODE_ENV==='development');
var PRODUCTION=(process.env.NODE_ENV==='production');
var entry=PRODUCTION?["./src/index.js"]:[  './src/index.js', 'webpack/hot/dev-server', 'webpack-dev-server/client?http://localhost:8080' ]
var plugins=PRODUCTION?
    [
        new webpack.optimize.UglifyJsPlugin({
            comments:false,//是否保留注释
            mangle:true,//是否压缩变量以及函数
            compress:{
                warnings:false
            }
        }),
        new ExtractTextPlugin("style-[contenthash:10].css"),
        new htmlWebpackPlugin({
            template:'index-template.html'
        })
    ]:[
        new webpack.HotModuleReplacementPlugin()
    ]
plugins.push(new webpack.DefinePlugin({
    DEVELOPMENT:JSON.stringify(DEVELOPMENT),
    PRODUCTION:JSON.stringify(PRODUCTION)
}))
const cssIdentifier=PRODUCTION?'[hash:base64:10]':'[path][name]---[local]';
const cssLoader=PRODUCTION?ExtractTextPlugin.extract('css-loader?localIdentName='+cssIdentifier):['style-loader','css-loader?localIdentName='+cssIdentifier];
module.exports={
    externals:{
        'jquery':"jQuery"//外部公共库，不会被打包到bundle.js
    },
    devtool:"source-map",
    entry:entry,
    plugins:plugins,
    output:{
        path:path.join(__dirname,'dist'),
        publicPath:PRODUCTION?'./':'/dist/',
        filename:PRODUCTION?'bundle.[hash:12].min.js':'bundle.js'
    },
    module:{

        loaders:[{
            test:/\.js$/,
            loaders:['babel-loader'],
            exclude:"/node_modules/"
        },{
            test:/\.(png|jpg|gif)$/,
            loaders:['url-loader?limit=50000&name=images/[hash:12].[ext]'],
            exclude:'/node_modules/'
        },{
            test:/\.css$/,
            loaders:cssLoader,
            exclude:'/node_modules/'
        }]
    }
}