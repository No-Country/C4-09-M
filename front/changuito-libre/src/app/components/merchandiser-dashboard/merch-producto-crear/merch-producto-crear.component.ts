import { CategoryService } from './../../../services/category.service';
import { Category } from './../../../model/category';
import { Router } from '@angular/router';
import { ProductService } from './../../../services/product.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-merch-producto-crear',
  templateUrl: './merch-producto-crear.component.html',
  styleUrls: ['./merch-producto-crear.component.css']
})
export class MerchProductoCrearComponent implements OnInit {

  previsualizacion!: string;
  archivos: any = [];
  productForm!: FormGroup;
  categories: Category[] = [new Category(1, 'Arroz'),
  new Category(2, 'Legumbres'), new Category(3, 'Fideos')];
  categories2: any;

  constructor(public fb: FormBuilder, public productService: ProductService,
    public router: Router, public categoryService: CategoryService,
    private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.productForm = this.fb.group({
      idProduct: ['', Validators.required],
      brand: ['', Validators.required],
      name: ['', Validators.required],
      description: ['', Validators.required],
      content: ['', Validators.required],
      idImage: ['', Validators.required],
      wholesaler_price: ['', Validators.required],
      retail_price: ['', Validators.required],
      stock: ['', Validators.required],
      status: ['', Validators.required],
      idCategory: ['', Validators.required],
    });

    this.categoryService.getCategories().subscribe(data => {
      this.categories2 = data;
    }, err => (console.error(err))
    );
  }

  onSave(): void {
    this.productService.addProduct(this.productForm.value);
    this.router.navigate(['/merch-productos'])
  }

  cancelar(): void {
    this.router.navigate(['merchandiser-dashboard']);
  }

  capturarFile(event: any) {
    const archivoCapturado = event.target.files[0]
    this.extraerBase64(archivoCapturado).then((imagen: any) => {
      this.previsualizacion = imagen.base;
      console.log(imagen);

    })
    this.archivos.push(archivoCapturado)
    //
     console.log(event.target.files);

  }


  extraerBase64 = async ($event: any) => new Promise((resolve, reject) => {
    const unsafeImg = window.URL.createObjectURL($event);
    const image = this.sanitizer.bypassSecurityTrustUrl(unsafeImg);
    const reader = new FileReader();
    reader.readAsDataURL($event);
    reader.onload = () => {
      resolve({
        base: reader.result
      });
    };
    reader.onerror = error => {
      resolve({
        base: null
      });
    };

  }
  )

}
